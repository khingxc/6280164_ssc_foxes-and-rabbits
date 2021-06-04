package io.muic.ooc.fab.Observer;
import io.muic.ooc.fab.Field;
import io.muic.ooc.fab.view.SimulatorView;

public class SimulateViewObserver extends Observer{

    SimulatorView simulatorView;

    public SimulateViewObserver(SimulatorView sView){
        simulatorView = sView;
    }

    @Override
    public void update(int step, Field field) {
        simulatorView.showStatus(step, field);
    }

}
