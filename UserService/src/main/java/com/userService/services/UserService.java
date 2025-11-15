package com.userService.services;

import java.util.List;

import com.userService.entities.User;

public interface UserService {
	User saveUser(User user);
	List<User> getAllUser();
	User getUser(String userId);
	

}
