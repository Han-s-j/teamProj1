package com.project.apt.product.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MicrowaveOvenVO extends ProductBaseVO {

	private String standbyPowerWatt; // 대기모드 소비 전력(W)
	private String onModePowerWatt; // 온보드 소비 전력(W)
}
