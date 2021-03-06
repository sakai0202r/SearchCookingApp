package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Category;
import com.example.entity.Ryori;
import com.example.entity.Syokuzai;

@Repository
public interface RyoriRepository extends JpaRepository<Ryori, Integer> {
	
	// 食材名とカテゴリが一致するデータを検索
	@Query("select r from Ryori r\n"
			+ "where r.syokuzaimei= :syokuzaimei and r.categoryName = :categoryName")
	public List<Ryori> findBySyokuzaiAndCategoryName(@Param("syokuzaimei") Syokuzai syokuzaimei, @Param("categoryName") Category categoryName);
	
	@Query("select r from Ryori r\n"
			+ "where r.syokuzaimei= :syokuzaimei")
	public List<Ryori> findBySyokuzai(@Param("syokuzaimei") Syokuzai syokuzaimei);
	
	@Query("select r from Ryori r\n"
			+ "where r.categoryName = :categoryName")
	public List<Ryori> findByCategoryName(@Param("categoryName") Category categoryName);
	
	String query = "select * from ryori r\n"
			+ "inner join syokuzai s\n"
			+ "on r.syokuzai_id = s.syokuzai_id\n"
			+ "inner join category c\n"
			+ "on r.category_id = c.category_id\n"
			+ "where \n"
			+ "(r.ryorimei like %?1% or\n"
			+ "s.syokuzaimei like %?1% or\n"
			+ "c.category_name like %?1%)\n"
			+ "order by r.ryori_id";
	
	// フリーワードで検索
	@Query(value = query, nativeQuery = true)
	public List<Ryori> findFree(String text);
}