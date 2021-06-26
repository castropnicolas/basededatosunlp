package ar.edu.unlp.model;

public class Closed implements StateOperations {

    @Override
    public void paused(Run run) {

    }

    @Override
    public void active(Run run) {

    }

    @Override
    public void closed(Run run) {

    }

    @Override
    public Integer time(Run run) {
        Long time = (run.getEnd().getTime() - run.getStart().getTime()) / 1000;
        return time.intValue();
    }

    @Override
    public void addLocation(Run run, Location location) {

    }
}
