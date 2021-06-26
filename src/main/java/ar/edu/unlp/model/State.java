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
    public Integer time(Run run) {
        return operations.time(run);
    }

    @Override
    public void addLocation(Run run, Location location) {
        operations.addLocation(run, location);
    }

}
