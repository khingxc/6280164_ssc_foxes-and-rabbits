package io.muic.ooc.fab;

import java.util.List;
import java.util.Random;

public abstract class Animal extends Actor{

    // The animal's age.
    protected int age;

    private static final Random RANDOM = new Random();

    @Override
    public void initialize(boolean randomAge, Field field, Location location) {
        super.initialize(randomAge, field, location);
        if (randomAge){
            age = RANDOM.nextInt(getMaxAge());
        }
    }

    /**
     * Generate a number representing the number of births, if it can breed.
     *
     * @return The number of births (may be zero).
     */
    protected void giveBirth(List<Actor> newAnimals) {
        // New animals are born into adjacent locations.
        // Get a list of adjacent free locations.
        List<Location> free = field.getFreeAdjacentLocations(location);
        int births = breed();
        for (int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Actor young = createYoung(false, field, loc);
            newAnimals.add(young);
        }
    }

    /**
     * Check whether the animal is alive or not.
     *
     * @return true if the animal is still alive.
     */


    /**
     * Return the animal's location.
     *
     * @return The animal's location.
     */


    public abstract int getMaxAge();

    /**
     * Increase the age. This could result in the animal's death.
     */
    protected void incrementAge() {
        age++;
        if (age > getMaxAge()) {
            setDead();
        }
    }

    private Actor createYoung(boolean randomAge, Field field, Location location){
        return ActorFactory.createActor(getClass(), field, location);
    }

    /**
     * Place the animal at the new location in the given field.
     *
     * @param newLocation The animal's new location.
     */

    protected abstract double getBreedingProbability();
    protected abstract int getMaxLitterSize();

    private boolean canBreed() {
        return age >= getBreedingAge();
    }

    protected abstract int getBreedingAge();

    protected int breed() {
        int births = 0;
        if (canBreed() && RANDOM.nextDouble() <= getBreedingProbability()) {
            births = RANDOM.nextInt(getMaxLitterSize()) + 1;
        }
        return births;
    }

    /**
     * Indicate that the animal is no longer alive. It is removed from the field.
     */
    public void setDead() {
        setAlive(false);
        if (location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    /**
     * An animal can breed if it has reached the breeding age.
     *
     * @return true if the animal can breed, false otherwise.
     */

    /**
     * Check whether or not this animal is to give birth at this step. New
     * births will be made into free adjacent locations.
     *
     * @param animals A list to return newly born animals.
     */

    @Override
    public void act(List<Actor> animals){
        incrementAge();
        if (isAlive()) {
            giveBirth(animals);
            // Try to move into a free location.
            Location newLocation = moveToNewLocation();
            if (newLocation != null) {
                setLocation(newLocation);
            } else {
                // Overcrowding.
                setDead();
            }
        }
    }
}
