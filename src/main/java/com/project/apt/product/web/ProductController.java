package com.project.apt.product.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.apt.product.service.ProductService;
import com.project.apt.product.vo.ProductListVO;

@Controller
public class ProductController {
	
	@Autowired
	ProductService service;
	
	// 가전제품 화면으로 이동
	@GetMapping("/product")
	public String showProductPage(Model model) {
		List<ProductListVO> productList = service.getProductList(); // 페이지 이동 시 가전제품 목록 함께 넘김
		
		model.addAttribute("productList", productList);
		
		return "product/product";
	}
	
	// 가전제품 각 item 가져오기
	@GetMapping("/product/details")
	public String showProductDetails(String itemTable, Model model) {
	    List<ProductListVO> productList = service.getProductList();
	    model.addAttribute("productList", productList);
	    model.addAttribute("selectedItemTable", itemTable);

	    if (itemTable != null && !itemTable.isEmpty()) {
	        List<Map<String, Object>> detailList = service.getItemDetailsByKey(itemTable);
	        model.addAttribute("detailList", detailList);
	        System.out.println(detailList);
	    }
	    
	    System.out.println("itemTable: " + itemTable);
	    

	    return "product/product";
	}

}
