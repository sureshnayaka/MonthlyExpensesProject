package com.sg.user.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sg.user.dto.UserDto;
import com.sg.user.entity.Users;
import com.sg.user.exception.ResourceNotFoundException;
import com.sg.user.mapper.UserMapper;
import com.sg.user.repository.UserRepository;
import com.sg.user.serviceDB.UserServiceDB;
import com.sg.user.util.ResponseBuilder;

@Service
public class UserServicePolicy implements UserServiceDB {

	private final UserRepository userRepository;

	public UserServicePolicy(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public ResponseEntity<?> findUserById(Integer userId) {
		Users user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
		UserDto userDto = UserMapper.toDto(user);
		return ResponseEntity.ok(ResponseBuilder.success("User found", userDto, null));
	}

	@Override
	public ResponseEntity<?> findAllUser() {
		List<Users> users = userRepository.findAll();
		List<UserDto> userDtos = UserMapper.toDtoList(users);
		return ResponseEntity.ok(ResponseBuilder.success("All users fetched", userDtos, null));
	}

	@Override
	public ResponseEntity<?> saveUser(UserDto userDto) {
		Users userEntity = UserMapper.toEntity(userDto);
		Users savedUser = userRepository.save(userEntity);
		UserDto responseDto = UserMapper.toDto(savedUser);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseBuilder.success("User created successfully", responseDto, null));
	}

}