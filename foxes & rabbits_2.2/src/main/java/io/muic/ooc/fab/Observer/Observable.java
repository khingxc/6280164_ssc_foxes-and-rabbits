package io.muic.ooc.fab.Observer;

import io.muic.ooc.fab.Field;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

    List<Observer> obs = new ArrayList<Observer>();

    public void addObserver(Observer obv){
        obs.add(obv);
    }

    public void notifyAllObservers(int step, Field field){
        for (Observer ob : obs){
            ob.update(step, field);
        }
    }

}
