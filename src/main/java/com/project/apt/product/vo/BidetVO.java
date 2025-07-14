package com.project.apt.product.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BidetVO extends ProductBaseVO {

	private String standbyPowerWatt; //전열 대기 모드 소비 전력(W)
	private String offModePowerWatt; // 오프 모드 고비 전력(W)
}
