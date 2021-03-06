package ar.edu.unlp.model;

public interface StateOperations {

    void paused(Run run);

    void active(Run run);

    void closed(Run run);

    Integer time(Run run);

    void addLocation(Run run, Location location);

}
