package com.project.apt.product.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.apt.product.vo.ProductListVO;

@Mapper
public interface IProductDAO {

	// 가전제품 목록 가져오기
	public List<ProductListVO> getProductList();
	
	// 가전제품 각 item 가져오기
	// 향후 vo 사용 가능	
	public List<Map<String, Object>> getItemDetails(String itemTable) ;
}
