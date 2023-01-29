package com.example.amit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.amit.entities.User;
import com.example.amit.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	

	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user) {

		User b = null;

		try {
			b = this.userService.addUser(user);
			System.out.println(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(b);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@GetMapping
	public ResponseEntity<Optional<List<User>>> getLimitUsers(@RequestParam(value="limit") int limit) {

		Optional<List<User>> list = this.userService.getTopNUser(limit);
		if (list == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(list));
	}
	

	
	@GetMapping("/ages")
	public ResponseEntity<Optional<List<User>>> getUserDataByAge(@RequestParam(value="gt") int gt) {  // ResponseEntity<List<User>>

		Optional<List<User>> userByDob = this.userService.getUserByDob(gt);
		if (userByDob == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(userByDob));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUserData() { 

		List<User> list = this.userService.getAllUsers();
		if (list == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(list));
	}


}
