package com.example.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Favorite;
import com.example.service.FavoriteService;

@RestController
@RequestMapping("/ryori")
public class FavoriteRestController {
	
	@Autowired
	private FavoriteService favoriteService;
	
	@PostMapping("/detail/{ryoriId:.+}")
	public int addFavorite(@ModelAttribute Favorite favorite, @PathVariable("ryoriId") Integer ryoriId) {
		
		favoriteService.insertFavorite(favorite);
		
		return 0;
	}
	
	@DeleteMapping("/detail/{ryoriId:.+}")
	public int deleteFavorite(@ModelAttribute Favorite favorite, @PathVariable("ryoriId") Integer ryoriId, Model model) {
		model.addAttribute("ryoriId", ryoriId);
		favoriteService.deleteFavorite(favorite);
		
		return 0;
	}
}
