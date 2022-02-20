package com.example.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserDetailForm {
	private String userId;
	
	@NotBlank
	@Length(max = 20)
	private String userName;
	
	@Length(max = 32)
	private String password;
}