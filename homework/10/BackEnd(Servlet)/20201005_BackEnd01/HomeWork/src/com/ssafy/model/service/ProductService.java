package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.ProductDto;

public interface ProductService {

	void addProduct(ProductDto p);
	List<ProductDto> listProduct();
	void lastProduct(ProductDto product);

}
