package com.sg.user.serviceDB;

import org.springframework.http.ResponseEntity;

import com.sg.user.dto.UserDto;

public interface UserServiceDB {

	ResponseEntity<?> findUserById(Integer userId);

	ResponseEntity<?> findAllUser();

	ResponseEntity<?> saveUser(UserDto user);
}