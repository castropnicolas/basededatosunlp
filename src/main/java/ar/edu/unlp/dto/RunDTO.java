package ar.edu.unlp.dto;

import java.util.Date;

public class RunDTO {

	private String id;
	private Date start;
	private Date end;
	private String state;

	public RunDTO() {

	}

	public RunDTO(String anId, Date start) {
		this.setId(anId);
		this.setStart(start);
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
