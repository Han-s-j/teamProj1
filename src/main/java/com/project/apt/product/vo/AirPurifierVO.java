package com.project.apt.product.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AirPurifierVO extends ProductBaseVO {

	private String annualEnergyCost; // 연간 에너지 비용
}
