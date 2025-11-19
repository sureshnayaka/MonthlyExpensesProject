package com.sg.user.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // specify strategy
	private Integer id;

	@Column(name = "name")
	@JsonProperty("name")
	private String name;

	@Column(name = "email")
	@JsonProperty("email")
	private String email;

	@Column(name = "phone")
	@JsonProperty("phone")
	private String phone;

	@Column(name = "role")
	@JsonProperty("role")
	private String role; // e.g., "user" or "admin"

}