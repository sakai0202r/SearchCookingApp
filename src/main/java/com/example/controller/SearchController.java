package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.Category;
import com.example.entity.MUser;
import com.example.entity.Ryori;
import com.example.entity.Syokuzai;
import com.example.form.RyoriListForm;
import com.example.service.CategoryService;
import com.example.service.RyoriService;
import com.example.service.SyokuzaiService;
import com.example.service.UserService;

@Controller
public class SearchController {

	@Autowired
	private SyokuzaiService syokuzaiService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private RyoriService ryoriService;

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String getSearch(Model model) {

		MUser loginUser = userService.getLoginUserId();
		
		List<Syokuzai> syokuzaiList = syokuzaiService.getSyokuzaiList();
		List<Category> categoryList = categoryService.getCategoryList();
		
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("syokuzaiList", syokuzaiList);
		model.addAttribute("categoryList", categoryList);

		return "search";
	}

	@PostMapping("/ryori/list")
	public String postRyoriListRequest(@ModelAttribute RyoriListForm ryoriListForm, Model model) {
		
		MUser loginUser = userService.getLoginUserId();

		List<Ryori> ryoriList = ryoriService.getRyoriList(ryoriListForm);
		
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("ryoriList", ryoriList);
		
		System.out.print(ryoriList);
		return "list";
	}
}