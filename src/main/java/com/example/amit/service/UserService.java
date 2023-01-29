package com.example.amit.service;

import java.util.List;
import java.util.Optional;
import com.example.amit.entities.User;



public interface UserService {
	
	public User addUser(User user);
	
	public List<User> getAllUsers();
	
	public Optional<List<User>> getTopNUser(int limit);
	
	public Optional<List<User>> getUserByDob(int age);
	

}
