package com.epam.engx.cleancode.naming.task2;

import java.util.Arrays;

public class User {

	protected boolean isAdmin = false;

	private String dateOfBirth;

	private String userName;

	private User[] subordinateArray;

	private int rating;

	public User(String userName, String dateOfBirth, User[] subordinateArray) {
		this.dateOfBirth = dateOfBirth;
		this.userName = userName;
		this.subordinateArray = subordinateArray;
	}

	@Override
	public String toString() {
		return "User [dateOfBirth=" + dateOfBirth + ", name=" + userName + ", isAdmin=" + isAdmin + ", subordinates="
				+ Arrays.toString(subordinateArray) + ", rating=" + rating + "]";
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
