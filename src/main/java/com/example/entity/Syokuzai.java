package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="syokuzai") // 省略可
public class Syokuzai {
	
	@Id
	private Integer syokuzaiId;
	
	private String syokuzaimei;
}