package com.project.apt.apartment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.apt.apartment.dao.IAptDAO;
import com.project.apt.apartment.vo.AptAddressVO;
import com.project.apt.apartment.vo.AptElectricFeeVO;

@Service
public class AptService {

	@Autowired
	IAptDAO dao;
	
	// 구 불러오기
	public List<String> getDistrictList() {
		return dao.getDistrictList();
	}
	
	// 동 불러오기
	public List<String> getDongList(String district){
		return dao.getDongList(district);
	}
	 
	// 년도 불러오기
	public List<String> getYearList(){
		return dao.getYearList();
	}
	
	// 월 불러오기
	public List<String> getMonthList(){
		return dao.getMonthList();
	}
	
	// (비교페이지 검색) 다른집(아파트) 불러오기
	public List<AptAddressVO> getOtherAptList(String dong){
		return dao.getOtherAptList(dong);
	}
	
	// (비교페이지 검색) 우리집(아파트) 불러오기
	public List<AptAddressVO> getMyAptList(String dong, String addressNum){
		return dao.getMyAptList(dong, addressNum);
	}
	
	// 우리집 전기요금 불러오기
	 public AptElectricFeeVO getMyAptElectricFee(String myKaptCode, String myYear, String myMonth) {
		 return dao.getMyAptElectricFee(myKaptCode, myYear, myMonth);
	 }
	
	// 다른집 전기요금 불러오기
	 public AptElectricFeeVO getOtherAptElectricFee(String otherKaptCode, String otherYear, String otherMonth) {
		 return dao.getOtherAptElectricFee(otherKaptCode, otherYear, otherMonth);
	 }
}
