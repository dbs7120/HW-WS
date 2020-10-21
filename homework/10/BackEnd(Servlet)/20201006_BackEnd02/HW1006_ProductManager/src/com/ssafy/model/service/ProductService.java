package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.ProductDto;

public interface ProductService {

	public void addProduct(ProductDto productDto);

	public List<ProductDto> allProduct();

	public ProductDto searchProduct(int product_id);

	public void deleteProduct(int product_id);

}
