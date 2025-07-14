package com.project.apt.power.vo;

import lombok.Data;

// 전력사용량 데이터를 담는 VO
// 그래프 그릴 때 사용
@Data
public class PowerVO {

	private String powerYear;       /* 발생년(YYYY) */
	private String powertMonth;     /* 발생월(M)*/
	private String district;        /* 구 */
	private String powerHousehold;  /* 전력 사용 세대수 */
	private String powerUsage;      /* 평균 전력 사용량 */
	private String powerFee;        /* 평군 전기 요금 */
}
