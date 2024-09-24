package com.sit.repository;

import com.sit.entity.User;

public interface Repository{

	void addStudent(User user);
	User authenticateUser(String username, String password); // New method
	boolean checkIfEmailExists(String email); // New method

}
