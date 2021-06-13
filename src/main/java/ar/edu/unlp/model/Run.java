package ar.edu.unlp.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Run {

    private String id;
    private Date start;
    private Date end;
    private String state;
    private Collection<Location> locations;

    public Run() {
        this.setLocations(new ArrayList<>());
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
