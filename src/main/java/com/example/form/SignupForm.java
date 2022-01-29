package com.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class SignupForm {
	
	@NotBlank(groups = ValidGroup1.class)
	@Length(max = 20, groups = ValidGroup1.class)
	private String userId;
	
	@NotBlank(groups = ValidGroup1.class)
	@Length(max = 20, groups = ValidGroup1.class)
	private String userName;
	
	@NotBlank(groups = ValidGroup1.class)
	@Length(min = 8, max = 32, groups = ValidGroup2.class)
	@Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup2.class)
	private String password;
}