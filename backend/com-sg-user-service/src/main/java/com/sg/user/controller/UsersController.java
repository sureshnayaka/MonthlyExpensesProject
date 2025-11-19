package com.sg.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.user.entity.Users;
import com.sg.user.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UsersController {

	
	private final UserRepository repository;

	public UsersController(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/all")
	public List<Users> getAllUsers() {
		return repository.findAll();
	}

	@PostMapping("/add")
	public Users addUser(@RequestBody Users user) {
		System.out.println(user);
		return repository.save(user);
	}
}