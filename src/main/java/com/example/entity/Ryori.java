package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Ryori {
	
	@Id
	private Integer ryoriId;
	private String ryorimei;
	private Integer calorie;
	private Integer syokuzaiId;
	private Integer categoryId;
	
	@ManyToOne(optional=false)
	@JoinColumn(insertable=false, updatable=false, name="syokuzaiId")
	private Syokuzai syokuzaimei;
	
	@ManyToOne(optional=false)
	@JoinColumn(insertable=false, updatable=false, name="categoryId")
	private Category categoryName;
}