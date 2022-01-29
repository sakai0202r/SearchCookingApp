package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.MUser;
import com.example.form.GroupOrder;
import com.example.form.SignupForm;
import com.example.service.UserService;

@Controller
@RequestMapping("/user")
public class SignupController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/** ユーザー登録画面を表示 */
	@GetMapping("/signup")
	public String getSignup(@ModelAttribute SignupForm form) {
		return "user/signup";
	}
	
	/** ユーザー登録処理 */
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute @Validated(GroupOrder.class) SignupForm form, 
			BindingResult bindingResult) {
		
		// 入力チェック
		if(bindingResult.hasErrors()) {
			return "user/signup";
		}
		
		MUser user = modelMapper.map(form, MUser.class);
		userService.signup(user);
		
		return "redirect:/login";
	}
}