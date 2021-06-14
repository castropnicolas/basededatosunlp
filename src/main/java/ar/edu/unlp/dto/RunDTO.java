package ar.edu.unlp.dto;

import ar.edu.unlp.model.State;

import java.util.Date;

public class RunDTO {

    private String id;
    private Date start;
    private Date end;
    private State state;

    public RunDTO() {

    }

    public RunDTO(String anId, Date start, State state) {
        this.setId(anId);
        this.setStart(start);
        this.setState(state);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
