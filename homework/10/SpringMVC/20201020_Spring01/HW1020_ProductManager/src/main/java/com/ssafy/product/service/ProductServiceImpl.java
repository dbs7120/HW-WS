package com.ssafy.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.product.dao.ProductDao;
import com.ssafy.product.model.ProductDto;
import com.ssafy.product.model.SearchDto;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public void addProduct(ProductDto productDto) {
		productDao.addProduct(productDto);

	}

	@Override
	public List<ProductDto> allProduct(SearchDto searchDto) {
		return productDao.allProduct(searchDto);
	}

	@Override
	public void deleteProduct(int product_id) {
		productDao.deleteProduct(product_id);

	}

}
