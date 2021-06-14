package ar.edu.unlp.model;

public enum State implements StateOperations {

    CREATED(new Created()),
    CLOSED(new Closed()),
    ACTIVE(new Active());

    private final StateOperations operations;

    State(StateOperations operations) {
        this.operations = operations;
    }

    @Override
    public void next(Run run) {
        operations.next(run);
    }

    @Override
    public void prev(Run run) {
        operations.prev(run);
    }

    @Override
    public void printStatus() {
        operations.printStatus();
    }
}
