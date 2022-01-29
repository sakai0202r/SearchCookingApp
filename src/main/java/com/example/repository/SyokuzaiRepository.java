package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Syokuzai;

@Repository
public interface SyokuzaiRepository extends JpaRepository<Syokuzai, Integer> {
	
}
