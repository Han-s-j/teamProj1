package com.project.apt.apartment.vo;

import lombok.Data;

// 아파트 전기요금 VO
@Data
public class AptElectricFeeVO {

	private String kaptCode;    /* 단지 코드 */
	private String year;        /* 발생년(YYYY) */
	private String month;       /* 발생월(M) */
	private Integer publicFee;  /* 전기요금(공용) */
	private Integer privateFee; /* 전기요금(전용) */
	private Integer household;  /* 세대수 */
	
}
