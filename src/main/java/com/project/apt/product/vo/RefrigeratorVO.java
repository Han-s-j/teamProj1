package com.project.apt.product.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RefrigeratorVO extends ProductBaseVO {

	private String monthlyElectricityConsumption; // 월간 에너지 소비량
	private String annualEnergyCost; // 연간 에너지 비용
}
