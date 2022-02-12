package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Favorite;
import com.example.entity.Ryori;
import com.example.service.FavoriteService;
import com.example.service.RyoriService;

@Controller
@RequestMapping("/ryori")
public class RyoriDetailController {

	@Autowired
	private RyoriService ryoriService;
	
	@Autowired
	private FavoriteService favoriteService;

	@GetMapping("/detail/{ryoriId:.+}")
	public String getRyoriDetail(Ryori ryori, @ModelAttribute Favorite favorite, 
			Model model, @PathVariable("ryoriId") Integer ryoriId) {

		// 料理データを1件取得
		Ryori ryoriDetail = ryoriService.getRyoriDetail(ryoriId);
		
		// お気に入りしているかの判定
		boolean existFavorite = favoriteService.existFavorite(favorite);
		
		model.addAttribute("ryoriDetail", ryoriDetail);
		model.addAttribute("existFavorite", existFavorite);

		return "ryori/detail";
	}
}