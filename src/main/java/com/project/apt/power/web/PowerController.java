package com.project.apt.power.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.apt.power.vo.PowerRequestVO;

@Controller
public class PowerController {

	// dashboard 이동
	@GetMapping("/dashboard")
	public String showDashBoardPage() {
		return "/dashboard/dashboard";
	}

	@RestController
	@RequestMapping("/api")
	public class PowerUsageController {

		@PostMapping("/api/power/predict")
		public ResponseEntity<?> getPrediction(@RequestBody PowerRequestVO dto) {
			try {
				String flaskUrl = "http://localhost:5000/predict"; // Flask 서버 주소

				RestTemplate restTemplate = new RestTemplate();
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);

				Map<String, Object> requestMap = new HashMap<>();
				requestMap.put("dong", dto.getDong());
				requestMap.put("year", dto.getYear());

				HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestMap, headers);

				// Flask 응답 받기
				ResponseEntity<String> response = restTemplate.postForEntity(flaskUrl, entity, String.class);

				return ResponseEntity.ok(response.getBody());

			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("Flask 예측 요청 실패: " + e.getMessage());
			}
		}
	}
}
