package ar.edu.unlp.model;

public interface StateOperations {

    void printStatus();

    void paused(Run run);

    void active(Run run);

    void closed(Run run);
}
