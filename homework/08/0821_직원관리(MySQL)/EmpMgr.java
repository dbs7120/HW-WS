package d0821.Employee;

import java.util.ArrayList;

public interface EmpMgr {
	public boolean add(Employee emp);

	public ArrayList<Employee> search();

	public Employee search(int empNo);

	public ArrayList<Employee> search(String empName);

	public boolean update(int empNo, String empDept);

	public boolean delete(int empNo);

}
