package com.hcl.restservice.restfulapiservice.user;

public class User {

	private String firstName;
	private String lastName;

	private String project;

	public User(String firstName, String lastName, String project) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.project = project;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", project=" + project + "]";
	}

}
