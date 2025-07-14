package com.project.apt.product.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RiceCookerVO extends ProductBaseVO {

	private String ratedPowerConsumption; // 정격 소비 전력(W)
	private String standbyPower; // 대기 전력
	private String annualEnergyCost; // 연간 에너지 비용
	
	
}
