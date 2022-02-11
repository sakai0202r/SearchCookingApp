package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Favorite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // IDを自動採番
	@Column(name = "favorite_id")
	private Integer favoriteId;
	@Column(name = "user_id")
	private String userId;
	private Integer ryoriId;
	
	@ManyToOne
	@JoinColumn(insertable=false, updatable=false, name="ryoriId")
	private Ryori ryorimei;
	
}