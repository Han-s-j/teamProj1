package com.project.apt.product.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class KimchiRefrigeratorVO extends ProductBaseVO {

	private String monthlyPowerConsumption; // 월간 소비 전력(kWh/월)
	private String annualEnergyCost; // 연간 에너지 비용
	private String consumerEfficiencyRatingIndex; // 소비자 효율 등급 지표
}
