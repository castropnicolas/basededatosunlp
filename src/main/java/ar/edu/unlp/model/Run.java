package ar.edu.unlp.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Run {

    private String id;
    private Date start;
    private Date end;
    private Collection<Location> locations;
    private State state = State.ACTIVE;

    public Run() {
        this.setLocations(new ArrayList<>());
        this.setStart(new Date());
        this.addLocation(new Location());
    }

    public String getId() {
        return this.id;
    }

    public void setId(String anId) {
        this.id = anId;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Collection<Location> getLocations() {
        return locations;
    }

    public void setLocations(Collection<Location> locations) {
        this.locations = locations;
    }

    public void addLocation(Location location) {
        this.state.addLocation(this, location);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void paused() {
        state.paused(this);
    }

    public void active() {
        state.active(this);
    }

    public void closed() {
        state.closed(this);
    }

    public Integer time() {
        return state.time(this);
    }

}
