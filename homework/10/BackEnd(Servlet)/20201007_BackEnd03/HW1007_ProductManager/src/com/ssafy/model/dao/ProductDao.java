package com.ssafy.model.dao;

import java.util.List;

import com.ssafy.model.ProductDto;
import com.ssafy.model.SearchDto;

public interface ProductDao {

	public void addProduct(ProductDto productDto);

	public List<ProductDto> allProduct(SearchDto searchDto);

	public void deleteProduct(int product_id);
}
