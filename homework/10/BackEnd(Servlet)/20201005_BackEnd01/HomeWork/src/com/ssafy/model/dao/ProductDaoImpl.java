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

	private final String insertSQL = "INSERT INTO product (name, price, description) VALUES (?, ?, ?)";

	@Override
	public void addProduct(ProductDto productDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, productDto.getName());
			pstmt.setInt(2, productDto.getPrice());
			pstmt.setString(3, productDto.getDesc());

			pstmt.executeUpdate();
			System.out.println("추가 완료!");

		} catch (SQLException e) {
			System.out.println("입력 오류 : " + e);
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	private final String selectSQL = "SELECT * FROM product";

	@Override
	public List<ProductDto> listProduct() {
		List<ProductDto> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(selectSQL);
			rst = stmt.executeQuery();

			while (rst.next()) {
				ProductDto p = new ProductDto();

				p.setId(Integer.parseInt(rst.getString(1)));
				p.setName(rst.getString(2));

				p.setPrice(Integer.parseInt(rst.getString(3)));
				p.setDesc(rst.getString(4));

				list.add(p);
			}

		} catch (SQLException e) {
			System.out.println("조회 오류 : " + e);
		} finally {
			DBUtil.close(rst);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}

		return list;
	}

	private final String getLastSQL = "SELECT * FROM product WHERE id=(SELECT max(id) FROM product)";

	@Override
	public void lastProduct(ProductDto product) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(getLastSQL);
			rst = stmt.executeQuery();

			if (rst.next()) {
				product.setId(Integer.parseInt(rst.getString(1)));
				product.setName(rst.getString(2));

				product.setPrice(Integer.parseInt(rst.getString(3)));
				product.setDesc(rst.getString(4));
			}
			System.out.println(product.toString());

		} catch (SQLException e) {
			System.out.println("조회 오류 : " + e);
		} finally {
			DBUtil.close(rst);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}


	}

}
