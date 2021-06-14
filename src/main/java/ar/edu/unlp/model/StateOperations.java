package ar.edu.unlp.model;

public interface StateOperations {

    void next(Run run);

    void prev(Run run);

    void printStatus();
}
