package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class MUser {
	
	@Id
	private String userId;
	private String userName;
	private String password;
	private String role;
	
}