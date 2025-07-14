package com.project.apt.product.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FanVO extends ProductBaseVO {

	private String meps; // 최저 소비 효율
}
