package ar.edu.unlp.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class Run {

    private UUID id;
    private LocalDateTime start;
    private LocalDateTime end;
    private String state;
    private Collection<Location> locations;

    public Run() {
        this.setLocations(new ArrayList<>());
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID anId) {
        this.id = anId;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Collection<Location> getLocations() {
        return locations;
    }

    public void setLocations(Collection<Location> locations) {
        this.locations = locations;
    }

    public void addLocation(Location location) {
        this.getLocations().add(location);
    }

    /* public Integer speed() {
        return null;
    }

    public Integer distance() {
        return null;
    }

    public Integer duration() {
        return null;
    }

    public Integer speedAverage() {
        return null;
    }

    public Integer speedMinimum() {
        return null;
    }

    public Integer speedMaximum() {
        return null;
    }

    public Integer ranking() {
        return null;
    }*/
}
