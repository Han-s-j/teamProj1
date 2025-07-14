package com.project.apt.product.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RouterVO extends ProductBaseVO {

	private String ratedPowerWatt; // 정격 소비 전력(W)
	private String standbyPowerWatt; // 대기모드 소비 전력(W)
}
