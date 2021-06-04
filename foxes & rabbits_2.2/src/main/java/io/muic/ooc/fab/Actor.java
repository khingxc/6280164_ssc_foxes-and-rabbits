package io.muic.ooc.fab;
import java.util.List;
import java.util.Random;

public abstract class Actor {

    private boolean alive = true;
    protected Location location;
    protected Field field;

    private static final Random RANDOM = new Random();

    public void initialize(boolean randomAge, Field field, Location location) {
        this.field = field;
        setLocation(location);
    }

    protected void setLocation(Location newLocation) {
        if (location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Location getLocation() {
        return location;
    }

    protected abstract Location moveToNewLocation();

//    public void act(List<Animal> animals){
//        if (isAlive()) {
//            Location newLocation = moveToNewLocation();
//            if (newLocation != null) {
//                setLocation(newLocation);
//            }
//        }
//    }
    protected abstract void act(List<Actor> actors);

}
