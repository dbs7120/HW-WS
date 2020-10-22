package com.ssafy.product.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ssafy.product.model.ProductDto;
import com.ssafy.product.model.SearchDto;
import com.ssafy.util.SqlMapConfig;

@Repository
public class ProductDaoImpl implements ProductDao {


	@Override
	public void addProduct(ProductDto productDto) {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			sqlSession.insert("com.ssafy.product.model.dao.ProductDao.addProduct", productDto);
		}

	}

	@Override
	public List<ProductDto> allProduct(SearchDto searchDto) {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectList("com.ssafy.product.model.dao.ProductDao.allProduct", searchDto);
		}
	}

	@Override
	public void deleteProduct(int product_id) {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			sqlSession.delete("com.ssafy.product.model.dao.ProductDao.deleteProduct", product_id);
		}
	}

}
