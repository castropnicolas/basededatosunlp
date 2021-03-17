package ar.edu.unlp.dto;

import java.util.UUID;

public class UserDTO {

	private UUID id;
	private String name;
	private String username;

	public UserDTO() {

	}

	public UserDTO(UUID anId, String anUsername, String aName) {
		this.setId(anId);
		this.setName(aName);
		this.setUsername(anUsername);
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID anId) {
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
