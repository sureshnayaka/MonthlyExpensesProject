package com.sg.user.mapper;

import com.sg.user.dto.UserDto;
import com.sg.user.entity.Users;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

	// Convert Entity to DTO
	public static UserDto toDto(Users user) {
		if (user == null) {
			return null;
		}
		return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getRole());
	}

	// Convert DTO to Entity (Useful for Create/Update)
	public static Users toEntity(UserDto dto) {
		if (dto == null) {
			return null;
		}
		return new Users(dto.getId(), dto.getName(), dto.getEmail(), dto.getPhone(), dto.getRole());
	}

	// Convert List of Entities to List of DTOs
	public static List<UserDto> toDtoList(List<Users> users) {
		return users.stream().map(UserMapper::toDto).collect(Collectors.toList());
	}
}