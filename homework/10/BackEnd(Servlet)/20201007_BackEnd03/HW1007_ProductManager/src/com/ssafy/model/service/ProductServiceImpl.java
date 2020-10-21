package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.ProductDto;
import com.ssafy.model.SearchDto;
import com.ssafy.model.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {

	private static ProductService productService;

	private ProductServiceImpl() {
	}

	public static ProductService getProductService() {
		if (productService == null)
			productService = new ProductServiceImpl();
		return productService;
	}

	@Override
	public void addProduct(ProductDto productDto) {
		ProductDaoImpl.getProductDao().addProduct(productDto);

	}

	@Override
	public List<ProductDto> allProduct(SearchDto searchDto) {
		return ProductDaoImpl.getProductDao().allProduct(searchDto);
	}

	@Override
	public void deleteProduct(int product_id) {
		ProductDaoImpl.getProductDao().deleteProduct(product_id);

	}

}
