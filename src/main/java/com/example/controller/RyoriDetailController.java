package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.MUser;
import com.example.entity.Ryori;
import com.example.service.RyoriService;
import com.example.service.UserService;

@Controller
@RequestMapping("/ryori")
public class RyoriDetailController {

	@Autowired
	private RyoriService ryoriService;

	@Autowired
	private UserService userService;

	@GetMapping("/detail/{ryoriId:.+}")
	public String getRyoriDetail(Ryori ryori, Model model, @PathVariable("ryoriId") Integer ryoriId) {

		MUser loginUser = userService.getLoginUserId();

		// 料理データを1件取得
		Ryori ryoriDetail = ryoriService.getRyoriDetail(ryoriId);
		model.addAttribute("ryoriDetail", ryoriDetail);
		model.addAttribute("loginUser", loginUser);

		return "ryori/detail";
	}
}