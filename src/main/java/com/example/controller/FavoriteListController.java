package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.entity.Favorite;
import com.example.service.FavoriteService;

@Controller
public class FavoriteListController {
	
	@Autowired
	private FavoriteService favoriteService;
	
	@GetMapping("/account/favorites")
	public String getFavoriteRyoriList(Model model) {
		List<Favorite> favoriteRyoriList = favoriteService.getFavoriteRyoriList();
		
		model.addAttribute("list", favoriteRyoriList);
		
		return "ryori/favoriteList";
	}

}
