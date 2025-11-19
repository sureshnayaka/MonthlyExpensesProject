package com.sg.user.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sg.user.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
}