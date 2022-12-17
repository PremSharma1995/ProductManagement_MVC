package com.jbk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private String username;
	private String password;
	private String gender;
	private String role;
	private String question;
	private String answer;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String username, String password, String gender, String role, String question, String answer) {
		super();
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.role = role;
		this.question = question;
		this.answer = answer;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Customer [username=" + username + ", password=" + password + ", gender=" + gender + ", role=" + role
				+ ", question=" + question + ", answer=" + answer + "]";
	}
	
	
	
	
	

}
