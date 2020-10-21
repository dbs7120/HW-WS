package com.ssafy.model.dao;

import java.util.List;

import com.ssafy.model.ProductDto;

public interface ProductDao {

	public void addProduct(ProductDto productDto);

	public List<ProductDto> allProduct();

	public ProductDto searchProduct(int product_id);

	public void deleteProduct(int product_id);
}
