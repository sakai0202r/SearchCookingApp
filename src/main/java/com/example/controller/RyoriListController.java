package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Category;
import com.example.entity.Ryori;
import com.example.entity.Syokuzai;
import com.example.form.RyoriListForm;
import com.example.service.CategoryService;
import com.example.service.RyoriService;
import com.example.service.SyokuzaiService;

@Controller
public class RyoriListController {

	@Autowired
	private SyokuzaiService syokuzaiService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private RyoriService ryoriService;
	
	@GetMapping("/")
	public String getSearch(Model model) {
		
		List<Syokuzai> syokuzaiList = syokuzaiService.getSyokuzaiList();
		List<Category> categoryList = categoryService.getCategoryList();
		List<Ryori> ryoriList = ryoriService.getAllRyoriList();
		
		model.addAttribute("syokuzaiList", syokuzaiList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("ryoriList", ryoriList);

		return "ryori/list";
	}

	@PostMapping("/")
	public String postRyoriListRequest(@ModelAttribute RyoriListForm ryoriListForm, @RequestParam("text") String text, Model model) {
		
		List<Syokuzai> syokuzaiList = syokuzaiService.getSyokuzaiList();
		List<Category> categoryList = categoryService.getCategoryList();
		List<Ryori> ryoriList;
		
		if(text != "") {
			ryoriList = ryoriService.getRyoriListFree(text);
		} else {
			ryoriList = ryoriService.getRyoriList(ryoriListForm);
		}
		
		model.addAttribute("syokuzaiList", syokuzaiList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("ryoriList", ryoriList);
		
		return "ryori/list";
	}
}