package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Favorite;
import com.example.entity.MUser;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer>  {
	
	@Transactional
	@Query("select f from Favorite f\n"
			+ "where user_id= :userId")
	public List<Favorite> favoriteRyoriList(@Param("userId") MUser userId);
	
	@Modifying
	@Transactional
	@Query("delete from Favorite f\n"
			+ "where user_id = :userId\n"
			+ "and ryori_id = :ryoriId")
	public void deleteFavorite(@Param("userId") String userId, @Param("ryoriId") Integer ryoriId);
	
	@Query("select f from Favorite f\n"
			+ "where user_id = :userId\n"
			+ "and ryori_id = :ryoriId")
	public Favorite findFavorite(@Param("userId") String userId, @Param("ryoriId") Integer ryoriId);

}