package com.project.apt.product.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.apt.product.dao.IProductDAO;
import com.project.apt.product.vo.ProductListVO;

@Service
public class ProductService {

	@Autowired
	IProductDAO dao;
	
	// 가전제품 목록 가져오기
	public List<ProductListVO> getProductList(){
		return dao.getProductList();
	}
	
	// 각 가전제품 item 가져오기
	public List<Map<String, Object>> getItemDetailsByKey(String itemTable) {
	    return dao.getItemDetails(itemTable);
	}
}
