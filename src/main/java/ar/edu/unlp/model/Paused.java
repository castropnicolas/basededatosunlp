package ar.edu.unlp.model;

import java.util.Date;

public class Paused implements StateOperations {

    @Override
    public void paused(Run run) {
    }

    @Override
    public void active(Run run) {
        run.setState(State.ACTIVE);
        run.setEnd(null);
    }

    @Override
    public void closed(Run run) {
        run.setState(State.CLOSED);
        run.setEnd(new Date());
    }

}
