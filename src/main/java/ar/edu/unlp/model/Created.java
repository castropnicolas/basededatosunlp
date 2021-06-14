package ar.edu.unlp.model;

public class Created implements StateOperations {

    @Override
    public void next(Run run) {
        run.setState(State.ACTIVE);
    }

    @Override
    public void prev(Run run) {
        System.out.println("The package is in its root state.");
    }

    @Override
    public void printStatus() {
        System.out.println("Carrera creada.");
    }
}
