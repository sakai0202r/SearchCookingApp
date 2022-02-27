package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Category;
import com.example.entity.Ryori;
import com.example.entity.Syokuzai;
import com.example.form.RyoriListForm;
import com.example.repository.RyoriRepository;

@Service
public class RyoriService {
	
	@Autowired
	private RyoriRepository ryoriRepository;
	
	public List<Ryori> getAllRyoriList() {
		return ryoriRepository.findAll();
	}
	
	// 条件に一致する料理リストを取得	
	public List<Ryori> getRyoriList(RyoriListForm ryoriListForm) {
		Syokuzai syokuzaimei = ryoriListForm.getSyokuzaimei();
		Category categoryName = ryoriListForm.getCategoryName();
		List<Ryori> result;
		
		if(syokuzaimei == null && categoryName == null) {
			result = ryoriRepository.findAll();
		} else if(syokuzaimei != null && categoryName != null) {
			result = ryoriRepository.findBySyokuzaiAndCategoryName(syokuzaimei, categoryName);
		} else if(syokuzaimei != null && categoryName == null) {
			result = ryoriRepository.findBySyokuzai(syokuzaimei);
		} else if(syokuzaimei == null && categoryName != null){
			result = ryoriRepository.findByCategoryName(categoryName);
		} else {
			result = null;
		}
		return result;
	}
	
	// 条件に一致する料理リストを取得	(フリーワード検索した場合)
	public List<Ryori> getRyoriListFree(String text) {
		return ryoriRepository.findFree(text);
	}
	
	public Ryori getRyoriDetail(Integer ryoriId) {
		Optional<Ryori> option = ryoriRepository.findById(ryoriId);
		Ryori ryoriDetail = option.orElse(null);
		return ryoriDetail;
	}
}