package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.ProductDto;
import com.ssafy.model.dao.ProductDao;
import com.ssafy.model.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	public ProductServiceImpl() {
		productDao = new ProductDaoImpl();
	}

	@Override
	public void addProduct(ProductDto productDto) {
		productDao.addProduct(productDto);
	}

	@Override
	public List<ProductDto> listProduct() {
		return productDao.listProduct();
	}

	@Override
	public void lastProduct(ProductDto product) {
		productDao.lastProduct(product);
	}

}
