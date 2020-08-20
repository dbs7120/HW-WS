package d0820.Product;

import java.sql.Connection;
import java.sql.DriverManager;
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
		con = getConnection(); // MySQL 연결
	}

	static ProductDao getInstance() { // SingleTon
		if (prodao == null) {
			prodao = new ProductDao();
		}
		return prodao;
	}

	public Connection getConnection() {
		String className = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(className);
			// 구문 확인하기
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/product_db?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
					"ssafy", "ssafy");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		System.out.println("<<<_DB연결 성공!_>>>");
		return con;
	}

	public void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void close(PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void endProgram() {
		close(resultSet);
		close(pstmt);
		close(con);
	}

	public int insertProduct(Product product) {
		int insert = 0;
		if (con != null) {
			sql = "INSERT INTO product (product_id, name, type, price, amount) VALUES (?,?,?,?,?)";

			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, product.getProNum());
				pstmt.setString(2, product.getProName());
				pstmt.setString(3, product.getProType());
				pstmt.setInt(4, product.getProPrice());
				pstmt.setInt(5, product.getProAmount());
				insert = pstmt.executeUpdate();

			} catch (SQLException e) {
				System.out.println("저장 실패! " + e);
			}

		}
		return insert;
	}

	public ArrayList<Product> selectAllProduct() {
		ArrayList<Product> products = new ArrayList<Product>();
		Product product = null;
		if (con != null) {
			sql = "select * from product"; // select all
			try {
				pstmt = con.prepareStatement(sql);
				resultSet = pstmt.executeQuery();
				while (resultSet.next()) {
//					System.out.print("제품 번호: " + resultSet.getInt(1) + "\t");
//					System.out.print("제품 이름: " + resultSet.getString(2) + "\t");
//					System.out.print("제품 종류: " + resultSet.getString(3) + "\t");
//					System.out.print("제품 가격: " + resultSet.getInt(4) + "\t");
//					System.out.println("제품 수량: " + resultSet.getInt(5));
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
			}
		}
		return products;
	}

	public ArrayList<Product> selectProductByName(String str) {
		ArrayList<Product> products = new ArrayList<Product>();
		Product product = null;

		if (con != null) {
			sql = "select * from product where name like ?;"; // select by name(포함, like적용)
			try {
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
			}
		}
		return products;
	}

	public ArrayList<Product> selectTVOrRef(int select) { // Select 1 : TV | Select 2 : 냉장고
		ArrayList<Product> products = new ArrayList<Product>();
		Product product = null;

		String type = (select == 1) ? "TV" : "냉장고";

		if (con != null) {
			sql = "select * from product where Type = ?;"; // select by name(포함, like적용)
			try {
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
			}
		}
		return products;
	}

	public ArrayList<Product> selectUnderPrice(int price) {
		ArrayList<Product> products = new ArrayList<Product>();
		Product product = null;

		if (con != null) {
			sql = "select * from product where price <= ?;"; // select by name(포함, like적용)
			try {
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
			}
		}
		return products;
	}

	public int updateProduct(int proNum, int proPrice) {
		int update = 0;
		if (con != null) {
			sql = "update product set price = ? where product_id = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, proPrice);
				pstmt.setInt(2, proNum);
				update = pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return update;

	}

	public int deleteProduct(int proNum) {
		int delete = 0;
		if (con != null) {
			sql = "delete product where product_id = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, proNum);
				delete = pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return delete;
	}
}
