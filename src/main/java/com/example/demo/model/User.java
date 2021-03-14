package com.example.demo.model;

import java.util.UUID;

public class User {

	private UUID id;

	private String username;

	private String password;

	private String name;

	public User() {

	}

	public User(String anUsername, String aPassword, String aName) {
		this.setUsername(anUsername);
		this.setName(aName);
		this.setPassword(aPassword);
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String aPassword) {
		this.password = aPassword;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String aName) {
		this.name = aName;
	}

}
