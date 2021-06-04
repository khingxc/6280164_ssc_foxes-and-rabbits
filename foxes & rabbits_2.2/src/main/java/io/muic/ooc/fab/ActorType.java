package io.muic.ooc.fab;

import java.awt.*;

public enum ActorType {
    RABBIT(0.2, Rabbit.class, Color.ORANGE),
    FOX(0.2, Fox.class, Color.BLUE),
    TIGER(0.05, Tiger.class, Color.RED),
    HUNTER(0.02, Hunter.class, Color.BLACK);

    private double creationProbability;

    private Class actorClass;

    private Color color;

    ActorType(double creationProbability, Class actorClass, Color color){
        this.creationProbability = creationProbability;
        this.actorClass = actorClass;
        this.color = color;
    }

    public double getCreationProbability(){
        return creationProbability;
    }

    public Class getActorClass(){
        return actorClass;
    }

    public Color getColor(){
        return color;
    }
}
