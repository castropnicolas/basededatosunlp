package ar.edu.unlp.model;

public class Person {

	private String id;

	private String name;

	private String phone;

	private String email;

	public Person() {

	}

	public String getId() {
		return this.id;
	}

	public void setId(String anId) {
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
