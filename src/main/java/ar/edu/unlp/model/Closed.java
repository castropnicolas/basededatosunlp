package ar.edu.unlp.model;

public class Closed implements StateOperations {

    @Override
    public void printStatus() {
        System.out.println("Carrera cerrada.");
    }

    @Override
    public void paused(Run run) {

    }

    @Override
    public void active(Run run) {

    }

    @Override
    public void closed(Run run) {

    }

}
