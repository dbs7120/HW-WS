package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.ProductDto;
import com.ssafy.util.DBUtil;

public class ProductDaoImpl implements ProductDao {
	private static ProductDao productDao;

	private ProductDaoImpl() {
	}

	public static ProductDao getProductDao() {
		if (productDao == null)
			productDao = new ProductDaoImpl();
		return productDao;
	}

	@Override
	public void addProduct(ProductDto productDto) {
		final String insertSQL = "INSERT INTO product (product_id, name, type, price, amount) VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setInt(1, productDto.getProduct_id());
			pstmt.setString(2, productDto.getName());
			pstmt.setString(3, productDto.getType());
			pstmt.setInt(4, productDto.getPrice());
			pstmt.setInt(5, productDto.getAmount());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	@Override
	public List<ProductDto> allProduct() {
		final String allSQL = "select * from product";
		List<ProductDto> list = new ArrayList<ProductDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(allSQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductDto productDto = new ProductDto();
				productDto.setProduct_id(rs.getInt("product_id"));
				productDto.setName(rs.getString("name"));
				productDto.setType(rs.getString("type"));
				productDto.setPrice(rs.getInt("price"));
				productDto.setAmount(rs.getInt("amount"));
				list.add(productDto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return list;
	}

	@Override
	public ProductDto searchProduct(int product_id) {
		final String searchSQL = "select * from product where product_id = ?";
		ProductDto productDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(searchSQL);
			pstmt.setInt(1, product_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				productDto = new ProductDto();
				productDto.setProduct_id(rs.getInt("product_id"));
				productDto.setName(rs.getString("name"));
				productDto.setType(rs.getString("type"));
				productDto.setPrice(rs.getInt("price"));
				productDto.setAmount(rs.getInt("amount"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return productDto;
	}

	@Override
	public void deleteProduct(int product_id) {
		final String deleteSQL = "delete from product where product_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, product_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}

	}

}
