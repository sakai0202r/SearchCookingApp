package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.MUser;

@Repository
public interface UserRepository extends JpaRepository<MUser, String> {
	
	//* ログインユーザー検索 */
	@Query("select user from MUser user"
			+ " where userId= :userId")
	public MUser findLoginUser(@Param("userId") String userId);
	
	//* ユーザー更新検索 */
	@Modifying // insert, update, deleteを実行する際に使用
	@Query("update MUser"
			+ " set userName = :userName,"
			+ " password = :password"
			+ " where userId= :userId")
	public Integer updataUser(@Param("userId") String userId, @Param("userName") String userName, @Param("password") String password);
	
}