package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="category")
public class Category {
	
	@Id
	private Integer categoryId;
	
	@Column(name="category_name")
	private String categoryName;
}