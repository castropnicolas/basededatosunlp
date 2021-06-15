package ar.edu.unlp.model;

import java.util.Date;

public class Active implements StateOperations {

    @Override
    public void paused(Run run) {
        run.setState(State.PAUSED);
        run.setTime(time(run));
    }

    @Override
    public void active(Run run) {

    }

    @Override
    public void closed(Run run) {
        run.setState(State.CLOSED);
        run.setEnd(new Date());
    }

    @Override
    public Integer time(Run run) {
        Date currentTime = new Date();
        Long time = (currentTime.getTime() - run.getStart().getTime()) / 1000;
        return time.intValue();
    }

}
