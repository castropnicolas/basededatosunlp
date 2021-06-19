package ar.edu.unlp.model;

public interface StateOperations {

    void paused(Run run);

    void active(Run run);

    void closed(Run run);

}
