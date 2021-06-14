package ar.edu.unlp.model;

public class Active implements StateOperations {

    @Override
    public void printStatus() {
        System.out.println("Carrera actiava.");
    }

    @Override
    public void paused(Run run) {
        run.setState(State.PAUSED);
    }

    @Override
    public void active(Run run) {

    }

    @Override
    public void closed(Run run) {
        run.setState(State.CLOSED);
    }

}
