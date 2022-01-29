package com.example.form;

import com.example.entity.Category;
import com.example.entity.Syokuzai;

import lombok.Data;

@Data
public class RyoriListForm {
	
	private Syokuzai syokuzaimei;
	private Category categoryName;
}
