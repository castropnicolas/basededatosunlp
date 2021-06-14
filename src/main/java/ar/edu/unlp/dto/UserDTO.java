package ar.edu.unlp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDTO {

	private String id;

	@NotEmpty
	private String name;

	@NotNull
	private String username;

	public UserDTO() {

	}

	public UserDTO(String anId, String anUsername, String aName) {
		this.setId(anId);
		this.setName(aName);
		this.setUsername(anUsername);
	}

	public String getId() {
		return this.id;
	}

	public void setId(String anId) {
		this.id = anId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String anUsername) {
		this.username = anUsername;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String aName) {
		this.name = aName;
	}

}
