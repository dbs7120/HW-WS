package com.ssafy.product.dao;

import java.util.List;

import com.ssafy.product.model.ProductDto;
import com.ssafy.product.model.SearchDto;

public interface ProductDao {
	public void addProduct(ProductDto productDto);

	public List<ProductDto> allProduct(SearchDto searchDto);

	public void deleteProduct(int product_id);
}
