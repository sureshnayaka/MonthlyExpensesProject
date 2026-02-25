package com.sg.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.user.dto.UserDto;
import com.sg.user.serviceDB.UserServiceDB;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	private final UserServiceDB userService;

	public UsersController(UserServiceDB userService) {
		this.userService = userService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Integer id) {

		return userService.findUserById(id);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllUsers() {

		return userService.findAllUser();
	}

	@PostMapping("/save")
	public ResponseEntity<?> saveUsers(@RequestBody UserDto users) {

		return userService.saveUser(users);
	}

}