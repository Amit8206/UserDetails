package com.example.amit.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.amit.dao.UserRepository;
import com.example.amit.entities.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	

	@Override
	public User addUser(User user) {
		return this.userRepository.save(user);
	}
	
	@Override
	public List<User> getAllUsers() {
		return (List<User>) this.userRepository.getAllUser();
	}

	@Override
	public Optional<List<User>> getTopNUser(int limit) {
		return this.userRepository.getTopNUser(limit);
	}

	@Override
	public Optional<List<User>> getUserByDob(int age) {
		return this.userRepository.getUserDob(age);
	}
	

}
