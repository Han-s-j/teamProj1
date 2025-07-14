package com.project.apt.apartment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.apt.apartment.vo.AptAddressVO;
import com.project.apt.apartment.vo.AptElectricFeeVO;

@Mapper
public interface IAptDAO {

	// 구 불러오기(전기세 비교 페이지)
	public List<String> getDistrictList();

	// 동 불러오기(전기세 비교 페이지)
	public List<String> getDongList(String district);
	
	// 비교 년도 불러오기(전기세 비교 페이지)
	public List<String> getYearList();
	
	// 비교 월 불러오기(전기세 비교 페이지)
	public List<String> getMonthList();
	
	// 아파트 목록 불러오기(우리집 검색)
	public List<AptAddressVO> getMyAptList(@Param("dong") String dong, @Param("addressNum") String addressNum);
	
	// 아파트 목록 불러오기(다른 집, 동만 검색)
	public List<AptAddressVO> getOtherAptList(String dong);
	
	// 우리집 전기요금 불러오기
	public AptElectricFeeVO getMyAptElectricFee(@Param("kaptCode") String kaptCode,
									            @Param("year") String year,
									            @Param("month") String month);
		
	// 다른집 전기요금 불러오기
	public AptElectricFeeVO getOtherAptElectricFee(@Param("kaptCode") String kaptCode,
										            @Param("year") String year,
										            @Param("month") String month);


}
