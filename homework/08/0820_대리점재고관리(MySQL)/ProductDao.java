package d0820.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {

	static ProductDao prodao = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet resultSet = null;
	private String sql = "";

	private ProductDao() {
	}

	static ProductDao getInstance() { // SingleTon
		if (prodao == null) {
			prodao = new ProductDao();
		}
		return prodao;
	}

	public int insertProduct(Product product) {
		int insert = 0;
		sql = "INSERT INTO product (product_id, name, type, price, amount) VALUES (?,?,?,?,?)";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, product.getProNum());
			pstmt.setString(2, product.getProName());
			pstmt.setString(3, product.getProType());
			pstmt.setInt(4, product.getProPrice());
			pstmt.setInt(5, product.getProAmount());
			insert = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("저장 실패! " + e);
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}

		return insert;
	}

	public ArrayList<Product> selectAllProduct() {
		ArrayList<Product> products = new ArrayList<Product>();
		Product product = null;
		sql = "select * from product"; // select all
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				product = new Product();
				product.setProNum(resultSet.getInt(1));
				product.setProName(resultSet.getString(2));
				product.setProType(resultSet.getString(3));
				product.setProPrice(resultSet.getInt(4));
				product.setProAmount(resultSet.getInt(5));
				products.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
		return products;
	}

	public ArrayList<Product> selectProductByName(String str) {
		ArrayList<Product> products = new ArrayList<Product>();
		Product product = null;
		sql = "select * from product where name like ?;"; // select by name(포함, like적용)
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + str + "%");
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				product = new Product();
				product.setProNum(resultSet.getInt(1));
				product.setProName(resultSet.getString(2));
				product.setProType(resultSet.getString(3));
				product.setProPrice(resultSet.getInt(4));
				product.setProAmount(resultSet.getInt(5));
				products.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}

		return products;
	}

	public ArrayList<Product> selectTVOrRef(int select) { // Select 1 : TV | Select 2 : 냉장고
		ArrayList<Product> products = new ArrayList<Product>();
		Product product = null;

		String type = (select == 1) ? "TV" : "냉장고";
		sql = "select * from product where Type = ?;";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, type);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				product = new Product();
				product.setProNum(resultSet.getInt(1));
				product.setProName(resultSet.getString(2));
				product.setProType(resultSet.getString(3));
				product.setProPrice(resultSet.getInt(4));
				product.setProAmount(resultSet.getInt(5));
				products.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}

		return products;
	}

	public ArrayList<Product> selectUnderPrice(int price) {
		ArrayList<Product> products = new ArrayList<Product>();
		Product product = null;
		sql = "select * from product where price <= ?;";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, price);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				product = new Product();
				product.setProNum(resultSet.getInt(1));
				product.setProName(resultSet.getString(2));
				product.setProType(resultSet.getString(3));
				product.setProPrice(resultSet.getInt(4));
				product.setProAmount(resultSet.getInt(5));
				products.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
		return products;
	}

	public int updateProduct(int proNum, int proPrice) {
		int update = 0;
		sql = "update product set price = ? where product_id = ?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, proPrice);
			pstmt.setInt(2, proNum);
			update = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
		return update;

	}

	public int deleteProduct(int proNum) {
		int delete = 0;

		sql = "delete from product where product_id = ?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, proNum);
			delete = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
		return delete;
	}
}
