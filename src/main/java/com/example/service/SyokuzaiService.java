package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Syokuzai;
import com.example.repository.SyokuzaiRepository;

@Service
public class SyokuzaiService {
	
	@Autowired
	private SyokuzaiRepository syokuzaiRepository;
	
	public List<Syokuzai> getSyokuzaiList() {
		
		List<Syokuzai> syokuzaiList = syokuzaiRepository.findAll();
		
		return syokuzaiList;
	}
}
