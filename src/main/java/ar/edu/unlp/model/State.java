package ar.edu.unlp.model;

public enum State implements StateOperations {

    ACTIVE(new Active()),
    PAUSED(new Paused()),
    CLOSED(new Closed());

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
    public void paused(Run run) {
        operations.paused(run);
    }

    @Override
    public void active(Run run) {
        operations.active(run);
    }

    @Override
    public void closed(Run run) {
        operations.closed(run);
    }

    @Override
    public void printStatus() {
        operations.printStatus();
    }
}
