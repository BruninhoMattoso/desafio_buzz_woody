package com.dextra.injectit.database;

public class User {
	private String name;
	private String password;
	private String creditCardNumber;
	
	public User(String name, String password, String cardNumber) {
		this.name = name;
		this.password = password;
		this.creditCardNumber = cardNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
}