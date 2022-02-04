package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Favorite;
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

}
