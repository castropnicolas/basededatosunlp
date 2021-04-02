package ar.edu.unlp.model;

import java.util.UUID;

public class Person {

	private UUID id;

	private String name;

	private String phone;

	private String email;

	public Person() {

	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID anId) {
		this.id = anId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String aName) {
		this.name = aName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
