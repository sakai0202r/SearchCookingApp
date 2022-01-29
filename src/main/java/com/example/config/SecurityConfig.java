package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// セキュリティ設定クラスを用意するためのアノテーション
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // パスワードのハッシュ化
	}
	
	/** セキュリティの対象外を設定 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		// セキュリティを適用しない(アクセス可)	
		web
		 .ignoring()
		  .antMatchers("/webjars/**")
		  .antMatchers("/css/**")
		  .antMatchers("/js/**");
	}
	
	/** セキュリティの各種設定 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// ログイン不要ページの設定
		http
		 .authorizeRequests()
		  .antMatchers("/login").permitAll() // 直リンクOK
		  .antMatchers("/user/signup").permitAll()
		  .anyRequest().authenticated(); // それ以外は直リンクNG
		
		// CSRF対策を無効に設定（一時的）
		http.csrf().disable();
		
		// ログイン処理
		http
		 .formLogin()
		  .loginProcessingUrl("/login") // ログイン処理のパス
		  .loginPage("/login") // ログインページの指定
		  .usernameParameter("userId") // ログインページのユーザーId
		  .passwordParameter("password")  // ログインページのパスワード
		  .defaultSuccessUrl("/search", true); // 成功後の遷移先
		
		// CSRF対策を無効に設定（一時的）
		http.csrf().disable();
	}
	
	//** 認証の設定 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		PasswordEncoder encoder = passwordEncoder();
		// インメモリ認証
		/*
		auth
		 .inMemoryAuthentication()
		  .withUser("user") // userを追加
		   .password(encoder.encode("user"))
		   .roles("GENERAL")
		  .and()
		  .withUser("admin") // adminを追加
		   .password(encoder.encode("admin"))
		   .roles("ADMIN");
	    */
		
		// ユーザーデータで認証
		auth
		 .userDetailsService(userDetailsService)
		 .passwordEncoder(encoder);
	}
}