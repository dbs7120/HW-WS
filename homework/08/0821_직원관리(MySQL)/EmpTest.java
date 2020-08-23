package d0821.Employee;

import java.util.ArrayList;
import java.util.Scanner;


public class EmpTest {

	public static void printProduct(ArrayList<Employee> in) {
		if (in == null) {
			System.out.println("사원이 존재하지 않습니다.");
			return;
		}
		for (Employee e : in) {
			System.out.println(e);
		}
	}

	public EmpTest() {
		EmpMgrImpl mgr = EmpMgrImpl.getInstance(); // 싱글톤 패턴
		int menu;
		String empName, empPosition, empDept;
		int empNo;
		Boolean check;
		Scanner sc = new Scanner(System.in);
		Employee employee;
		ArrayList<Employee> employees;

		while (true) { // start program

			System.out.println("┌─────────────────────>사원정보관리<─────────────────────────────────┐");
			System.out.println("│\t\t\t1. 사원저장\t\t\t\t │");
			System.out.println("│\t\t\t2. 사원전체출력\t\t\t\t │");
			System.out.println("│\t\t\t3. 사원검색(사번)\t\t\t\t │");
			System.out.println("│\t\t\t4. 사원검색(이름)\t\t\t\t │");
			System.out.println("│\t\t\t5. 사원부서변경\t\t\t\t │");
			System.out.println("│\t\t\t6. 사원삭제\t\t\t\t │");
			System.out.println("│\t\t\t0. 프로그램 종료\t\t\t\t │");
			System.out.println("└────────────────────────────────────────────────────────────────┘");

			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {

			case 1: // insert
				employee = new Employee();
				System.out.println(">사원 추가\n");

				System.out.print(">사번 : ");
				empNo = Integer.parseInt(sc.nextLine());
				employee.setEmpNo(empNo);

				System.out.print(">직원명 : ");
				empName = sc.nextLine();
				employee.setName(empName);

				System.out.print(">직위: ");
				empPosition = sc.nextLine();
				employee.setPosition(empPosition);

				System.out.print(">부서: ");
				empDept = sc.nextLine();

				if (empDept.equals(""))
					employee.setDept(null);
				else
					employee.setDept(empDept);

				check = mgr.add(employee);

				System.out.println(check ? ">추가완료" : ">추가실패");
				System.out.println();

				break; // end insert

			case 2: // Read
				System.out.println(">사원전체 목록\n");
				employees = mgr.search();
				if (employees.size() == 0) {
					System.out.println("항목이 비어있습니다.");
				} else {
					for (Employee b : employees) {
						System.out.println(b);
					}
				}
				System.out.println();

				break; // end read

			case 3: // Read
				System.out.println(">사원검색(사번)\n");
				employee = new Employee();

				System.out.print(">사번 : ");
				empNo = Integer.parseInt(sc.nextLine());
				//employee.setEmpNo(empNo);
				employee = mgr.search(empNo);

				if (employee.getName() == null) {
					System.out.println("null");
				} else {
					System.out.println(employee);
				}
				System.out.println();

				break; // end read

			case 4: // Read
				System.out.println(">사원검색(이름)\n");
				System.out.print(">직원명: ");
				empName = sc.nextLine();
				
				employees = mgr.search(empName);
				if (employees.size() == 0) {
					System.out.println("null");
				} else {
					for (Employee b : employees) {
						System.out.println(b);
					}
				}
				System.out.println();

				break; // end read

			case 5: // Update
				System.out.println(">사원부서변경\n");
				System.out.print(">사번 : ");
				empNo = Integer.parseInt(sc.nextLine());
				System.out.print(">부서명: ");
				empDept = sc.nextLine();

				check = mgr.update(empNo, empDept);
				System.out.println(check ? ">변경완료" : ">변경실패");
				System.out.println();
				break; // end Update

			case 6: // Delete
				System.out.println(">사원삭제\n");
				System.out.print(">사번 : ");
				empNo = Integer.parseInt(sc.nextLine());
				check = mgr.delete(empNo);
				System.out.println(check ? ">삭제완료" : ">삭제실패");
				System.out.println();
				break; // end delete

			case 0:
				System.out.println("프로그램을 종료합니다.");
				break;

			}
			if (menu == 0)
				break;

		}
		sc.close();

	}

	public static void main(String[] args) {
		new EmpTest();

	}

}
