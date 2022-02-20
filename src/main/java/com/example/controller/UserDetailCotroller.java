package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.MUser;
import com.example.form.UserDetailForm;
import com.example.service.UserService;

@Controller
public class UserDetailCotroller {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/account")
	public String getUserDetail(Model model) {
		
		MUser loginUser = userService.getLoginUserId();
		model.addAttribute("loginUser", loginUser);
		
		return "user/account";
	}
	
	/** ユーザー更新処理 */
	@PostMapping(value = "/account", params = "update")
	public String updateUser(@Validated UserDetailForm form, BindingResult bindingResult) {
		
		// 入力チェック
		if(bindingResult.hasErrors()) {
			return "redirect:/account";
		}
		
		userService.updateUserOne(form.getUserId(), form.getUserName(), form.getPassword());
		
		return "redirect:/account";
	}
}