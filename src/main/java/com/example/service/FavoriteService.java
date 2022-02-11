package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Favorite;
import com.example.entity.MUser;
import com.example.repository.FavoriteRepository;

@Service
public class FavoriteService {
	
	@Autowired
	private FavoriteRepository favoriteRipository;
	
	@Autowired
	private UserService userService;
	
	public List<Favorite> getFavoriteRyoriList() {
		return favoriteRipository.favoriteRyoriList(userService.getLoginUserId());
	}
	
	public void insertFavorite(Favorite favorite) {
		favorite.setUserId(userService.getUserId());
		favoriteRipository.save(favorite);
	}
	
	public void deleteFavorite(Favorite favorite) {
		favoriteRipository.deleteFavorite(userService.getUserId(), favorite.getRyoriId());
	}
	
	public boolean existFavorite(Favorite favorite) {
		Favorite resultFavorite = favoriteRipository.findFavorite(userService.getUserId(), favorite.getRyoriId());
		if(resultFavorite != null) {
			return true;
		} else {
			return false;
		}
	}
}
