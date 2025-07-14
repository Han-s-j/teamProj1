package com.project.apt.product.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TvVO extends ProductBaseVO {

	private String wattagePerSquareMeter; // m^2 당 소비 전력(W)
}
