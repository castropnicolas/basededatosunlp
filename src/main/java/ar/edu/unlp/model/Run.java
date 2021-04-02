package ar.edu.unlp.model;

import java.time.LocalDate;

public class Run extends User {

    private LocalDate start;
    private LocalDate end;
    private String state;

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer speed() {
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
    }
}
