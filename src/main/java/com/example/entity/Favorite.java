package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Favorite {
	
	@Id
	private Integer favoriteId;
	private String userId;
	private Integer ryoriId;
	
	@ManyToOne
	@JoinColumn(insertable=false, updatable=false, name="ryoriId")
	private Ryori ryorimei;
}