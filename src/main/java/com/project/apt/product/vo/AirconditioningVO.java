package com.project.apt.product.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
// 부모 클래스의 필드(itemKey 등을 함께 포함하기 위한 선언)
// 상속 -> xml 작성 요령은 notion에 상세 기술
@EqualsAndHashCode(callSuper = true)
public class AirconditioningVO extends ProductBaseVO {

	private String monthlyElectricity; // 냉방 기간 월간 소비 전력량
	private String energyEfficiency; // 에너지 소비 효율
}
