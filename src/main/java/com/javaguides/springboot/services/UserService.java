package com.javaguides.springboot.services;

import java.util.List;

import com.javaguides.springboot.model.User;

public interface UserService {
	User saveUser(User user);
	List<User> getAllUsers();
	User getUserById(long id);
	User updateUser(User user, long id);
	void deleteUser(long id);
}

