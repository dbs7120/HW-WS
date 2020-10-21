package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.ProductDto;
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
	public List<ProductDto> allProduct() {
		return ProductDaoImpl.getProductDao().allProduct();
	}

	@Override
	public ProductDto searchProduct(int product_id) {
		return ProductDaoImpl.getProductDao().searchProduct(product_id);
	}

	@Override
	public void deleteProduct(int product_id) {
		ProductDaoImpl.getProductDao().deleteProduct(product_id);

	}

}
