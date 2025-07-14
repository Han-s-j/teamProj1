package com.project.apt.product.vo;

import lombok.Data;

@Data
public class ProductBaseVO {

	// 각 product가 공통으로 갖고 있는 속성
	private int itemKey;
	private String companyName;
	private String modelName;
}
