package com.project.apt.apartment.vo;

import lombok.Data;

// 아파트 주소 VO
// feeCompare 페이지에서 주소 검색 시 이용
@Data
public class AptAddressVO {

	private String kaptCode; // 아파트 코드
	private String kaptName; // 아파트 이름
	private String address;  // 아파느 주소(한줄로 모든 주소 표시)
}
