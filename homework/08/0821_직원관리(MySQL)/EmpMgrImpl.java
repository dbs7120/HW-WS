package d0821.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpMgrImpl implements EmpMgr {

	static EmpMgrImpl empmgr = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet resultSet = null;
	private String sql = "";

	private EmpMgrImpl() {
	}

	static EmpMgrImpl getInstance() { // SingleTon
		if (empmgr == null) {
			empmgr = new EmpMgrImpl();
		}
		return empmgr;
	}

	// insert
	@Override
	public boolean add(Employee emp) {
		boolean add = false;
		sql = "INSERT INTO employee (empNo, empName, empPosition, empDept) VALUES (?,?,?,?)";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpNo());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getPosition());
			pstmt.setString(4, emp.getDept());
			int cnt = pstmt.executeUpdate();
			if (cnt > 0)
				add = true;
		} catch (SQLException e) {
			System.out.println("저장 실패! " + e);
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}

		return add;
	}

	// search All
	@Override
	public ArrayList<Employee> search() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		Employee employee = null;
		sql = "select * from employee"; // select all
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				employee = new Employee();
				employee.setEmpNo(resultSet.getInt(1));
				employee.setName(resultSet.getString(2));
				employee.setPosition(resultSet.getString(3));
				employee.setDept(resultSet.getString(4));

				employees.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
		return employees;
	}

	// search empNO
	@Override
	public Employee search(int empNo) {
		Employee employee = null;
		sql = "select * from employee where empNo = ?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				employee = new Employee();
				employee.setEmpNo(resultSet.getInt(1));
				employee.setName(resultSet.getString(2));
				employee.setPosition(resultSet.getString(3));
				employee.setDept(resultSet.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
		return employee;
	}

	// search name
	@Override
	public ArrayList<Employee> search(String empName) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		Employee employee = null;
		sql = "select * from employee where empName like ?;"; // select by name(포함, like적용)
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + empName + "%");
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				employee = new Employee();
				employee.setEmpNo(resultSet.getInt(1));
				employee.setName(resultSet.getString(2));
				employee.setPosition(resultSet.getString(3));
				employee.setDept(resultSet.getString(3));
				employees.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}

		return employees;
	}

	// update
	@Override
	public boolean update(int empNo, String empDept) {
		boolean update = false;
		sql = "update employee set empDept = ? where empNo = ?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empDept);
			pstmt.setInt(2, empNo);
			int cnt = pstmt.executeUpdate();
			if (cnt > 0)
				update = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
		return update;
	}

	// delete
	@Override
	public boolean delete(int empNo) {
		boolean delete = false;

		sql = "delete from employee where empNo = ?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			int cnt = pstmt.executeUpdate();
			if (cnt > 0)
				delete = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
		return delete;
	}
}
