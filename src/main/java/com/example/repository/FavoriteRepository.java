package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Favorite;
import com.example.entity.MUser;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer>  {
	
	@Query("select f from Favorite f\n"
//			+ "inner join Ryori r on r.ryori_id = f.ryori_id\n"
			+ "where user_id= :userId")
	public List<Favorite> favoriteRyoriList(@Param("userId") MUser userId);
	
}
