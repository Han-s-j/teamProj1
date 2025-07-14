package com.project.apt.apartment.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.apt.apartment.service.AptService;
import com.project.apt.apartment.vo.AptAddressVO;
import com.project.apt.apartment.vo.AptElectricFeeVO;

@Controller
public class AptController {

	@Autowired
	AptService service;
	
	// 비교 페이지 단순 이동
	@GetMapping("/feeCompare")
	public String showfeeComparePage(Model model) {
		List<String> districtList = service.getDistrictList(); // 구 리스트
		List<String> yearList = service.getYearList(); // 연도 리스트
		List<String> monthList = service.getMonthList(); // 월 리스트
		
		model.addAttribute("districtList", districtList);
		model.addAttribute("yearList", yearList);
		model.addAttribute("monthList", monthList);
		
		return "fee/feeCompare";
	}
	
	@GetMapping("/dongList")
	@ResponseBody
	public List<String> getDongList(@RequestParam String district) {
	    return service.getDongList(district);
	}
	
	@GetMapping("/getMyAptList")
	@ResponseBody
	public List<AptAddressVO> getMyAptList(@RequestParam("dong") String dong, @RequestParam("addressNum") String addressNum){
	    return service.getMyAptList(dong, addressNum);
	}
	
	@GetMapping("/getOtherAptList")
	@ResponseBody
	public List<AptAddressVO> getOtherAptList(@RequestParam String dong) {
	    return service.getOtherAptList(dong);
	}

	// 비교 결과를 처리하는 메서드
    @GetMapping("/compare")
    public String compareAptData(@RequestParam String myKaptCode, @RequestParam String myYear,
                                 @RequestParam String myMonth, @RequestParam String otherKaptCode,
                                 @RequestParam String otherYear, @RequestParam String otherMonth,
                                 Model model) {

        // 우리집과 다른집의 데이터 가져오기
        AptElectricFeeVO myAptFee = service.getMyAptElectricFee(myKaptCode, myYear, myMonth);
        AptElectricFeeVO otherAptFee = service.getOtherAptElectricFee(otherKaptCode, otherYear, otherMonth);

        // 모델에 데이터 추가
        model.addAttribute("myAptFee", myAptFee);
        model.addAttribute("otherAptFee", otherAptFee);

        return "feeComparePopup";  // 비교 결과 페이지
    }
    
    // 비교 상세 페이지 팝업 띄우기
    @GetMapping("/feeComparePopup")
    public String showFeeComparePopupPage() {
    	return "fee/feeComparePopup";
    }
    
    @GetMapping("/getFeeCompareData")
    @ResponseBody
    public Map<String, Object> getFeeCompareData(
            @RequestParam String myKaptCode,
            @RequestParam String otherKaptCode,
            @RequestParam String myYear,
            @RequestParam String myMonth,
            @RequestParam String otherYear,
            @RequestParam String otherMonth
    ) {

        AptElectricFeeVO myFee = service.getMyAptElectricFee(myKaptCode, myYear, myMonth);
        AptElectricFeeVO otherFee = service.getOtherAptElectricFee(otherKaptCode, otherYear, otherMonth);

		int myTotal = (myFee.getPublicFee() == null ? 0 : myFee.getPublicFee()) 
					+ (myFee.getPrivateFee() == null ? 0 : myFee.getPrivateFee());
		
		int myAvg = myFee.getHousehold() == null || myFee.getHousehold() == 0 
					? 0 : myTotal / myFee.getHousehold();
		
		int otherTotal = (otherFee.getPublicFee() == null ? 0 : otherFee.getPublicFee()) 
					   + (otherFee.getPrivateFee() == null ? 0 : otherFee.getPrivateFee());
		
		int otherAvg = otherFee.getHousehold() == null || otherFee.getHousehold() == 0 
					? 0 : otherTotal / otherFee.getHousehold();

        Map<String, Object> result = new HashMap<>();
        result.put("myYear", myYear);
        result.put("myMonth", myMonth);
        result.put("myFee", myAvg);
        result.put("otherFee", otherAvg);
        return result;
    }
	
}
