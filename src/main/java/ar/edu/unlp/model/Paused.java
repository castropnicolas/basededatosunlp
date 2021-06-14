package ar.edu.unlp.model;

public class Paused implements StateOperations {

    @Override
    public void printStatus() {
        System.out.println("Carrera pausada.");
    }

    @Override
    public void paused(Run run) {

    }

    @Override
    public void active(Run run) {
        run.setState(State.ACTIVE);
    }

    @Override
    public void closed(Run run) {
        run.setState(State.CLOSED);
    }
}
