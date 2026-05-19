package com.ait.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RegistrationBean {
	private String firstName, lastName,
	emailAddress, password;

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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getObscuredPassword() {
		return (firstLetter(password) + "..." + lastLetter(password));
	}

	public String register2() {
		return ("show-registration");
	}

	private String firstLetter(String s) {
		return (s.substring(0, 1));
	}

	private String lastLetter(String s) {
		int length = s.length();
		return (s.substring(length - 1, length));
	}
}
