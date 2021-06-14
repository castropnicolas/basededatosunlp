package ar.edu.unlp.dto;

import ar.edu.unlp.model.State;

import java.util.Date;

public class RunDTO {

    private String id;
    private Date start;
    private Date end;
    private State state;
    private Integer time;

    public RunDTO() {

    }

    public RunDTO(String anId, Date start, Date end, State state, Integer time) {
        this.setId(anId);
        this.setStart(start);
        this.setEnd(end);
        this.setState(state);
        this.setTime(time);
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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
