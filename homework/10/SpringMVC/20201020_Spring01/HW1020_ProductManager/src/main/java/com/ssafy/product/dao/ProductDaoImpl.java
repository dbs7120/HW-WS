package com.ssafy.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.product.model.ProductDto;
import com.ssafy.product.model.SearchDto;
import com.ssafy.util.DBUtil;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private DataSource dataSource;

	@Override
	public void addProduct(ProductDto productDto) {
		final String insertSQL = "INSERT INTO product (product_id, name, type, price, amount) VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
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
	public List<ProductDto> allProduct(SearchDto searchDto) {
		StringBuffer searchSQL = new StringBuffer();
		searchSQL.append("select * from product ");
		String searchType = searchDto.getSearchType();
		List<ProductDto> list = new ArrayList<ProductDto>();

		if (searchType != null && searchType.length() != 0) {
			String query = "";
			if ("price".equals(searchType))
				query = " < ? ";
			else if ("name".equals(searchType))
				query = " like ? ";
			else if ("type".equals(searchType))
				query = " like ?";

			searchSQL.append("where " + searchType + query);
		}
		searchSQL.append("order by product_id ");

		System.out.println(searchDto.getSearchType());
		System.out.println(searchDto.getSearchWord());

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(searchSQL.toString());

			if (searchType != null && searchType.length() != 0) {
				if ("price".equals(searchType))
					pstmt.setInt(1, Integer.valueOf(searchDto.getSearchWord()));
				else if ("name".equals(searchType))
					pstmt.setString(1, "%" + searchDto.getSearchWord() + "%");
				else if ("type".equals(searchType))
					pstmt.setString(1, "%" + searchDto.getSearchWord() + "%");
			}

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
	public void deleteProduct(int product_id) {
		final String deleteSQL = "delete from product where product_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
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
