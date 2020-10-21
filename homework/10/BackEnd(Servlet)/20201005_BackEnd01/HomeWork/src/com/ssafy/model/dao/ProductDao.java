package com.ssafy.model.dao;

import java.util.List;

import com.ssafy.model.ProductDto;

public interface ProductDao {

	void addProduct(ProductDto p);
	List<ProductDto> listProduct();
	void lastProduct(ProductDto product);

}
