package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.MUser;
import com.example.repository.UserRepository;

@Service
@Primary
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	/** ユーザー登録 */
	@Transactional
	public void signup(MUser user) {
		
		boolean exists = repository.existsById(user.getUserId());
		if(exists) {
			throw new DataAccessException("ユーザーが既に存在"){};
		}
		
		user.setRole("ROLE_FREE_MEMBER");
		
		String rawPassword = user.getPassword();
		user.setPassword(encoder.encode(rawPassword));
		
		repository.save(user);
	}
	
	
	/** ユーザー取得(1件) */
//	public MUser getUserOne(String userId) {	
//		Optional<MUser> option = repository.findById(userId);
//		MUser user = option.orElse(null);
//		return user;
//	}
	
	/** ログインユーザー取得 */
	public MUser getLoginUser(String userId) {
		return repository.findLoginUser(userId);
	}

	/** ログインユーザーのIDを取得 */
	public MUser getLoginUserId() {
		
		// ログインユーザーの情報を取得する
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userId = auth.getName();
		MUser loginUser = getLoginUser(userId);
		
		return loginUser;
	}
	
	/** ユーザー更新 */
	@Transactional
	public void updateUserOne(String userId, String userName, String password) {
		
		if ( password.isEmpty() || password == null) {
			/** ===　パスワードが空の場合は、DBから取得したパスワードを更新 === */
			repository.updataUser(userId, userName, getLoginUserId().getPassword());
		} else {
			// パスワードを暗号化して更新
			String encryptPassword = encoder.encode(password);
			repository.updataUser(userId, userName, encryptPassword);
		}
	}
	
}