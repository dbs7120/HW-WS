package d0820.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductTest {

	public static void printProduct(ArrayList<Product> in) {
		if (in == null) {
			System.out.println("제품이 존재하지 않습니다.");
			return;
		}
		for (Product e : in) {
			System.out.println(e);
		}
	}

	public ProductTest() {
		ProductDao dao = ProductDao.getInstance(); // 싱글톤 패턴
		int menu;
		String proName, proType;
		int proNum, proPrice, proAmount;
		Scanner sc = new Scanner(System.in);

		while (true) { // start program
			System.out.println("<<<____________Abc디지털 대리점 재고관리____________>>>");
			System.out.println("│\t\t1. 제품저장\t\t\t│"); // C
			System.out.println("│\t\t2. 제품목록\t\t\t│"); // R
			System.out.println("│\t\t3. 재고품목 금액변경\t\t\t│"); // U
			System.out.println("│\t\t4. 제품삭제\t\t\t│"); // D
			System.out.println("│\t\t0. 종료\t\t\t\t│");
			System.out.println("<<<___________________________________________>>>");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {

			case 1: // Create

				System.out.print(">제품 번호: ");
				proNum = sc.nextInt();
				sc.nextLine();

				System.out.print(">제품 이름: ");
				proName = sc.nextLine();

				System.out.print(">제품 종류: ");
				proType = sc.nextLine();

				System.out.print(">제품 가격: ");
				proPrice = sc.nextInt();
				sc.nextLine();

				System.out.print(">제품 수량: ");
				proAmount = sc.nextInt();
				sc.nextLine();

				if (dao.insertProduct(new Product(proNum, proName, proType, proPrice, proAmount)) > 0)
					System.out.println("저장 완료!");
				else
					System.out.println("저장 실패!");

				break; // end create

			case 2: // Read
				while (true) {
					System.out.println("1. 제품리스트전체 출력");
					System.out.println("2. 제품명으로 검색");
					System.out.println("3. 보유중인 TV확인");
					System.out.println("4. 보유중인 냉장고확인");
					System.out.println("5. 상품 가격검색(입력이하)");
					System.out.println("0. 뒤로가기");

					int readMenu = sc.nextInt();
					sc.nextLine();
					switch (readMenu) {

					case 1:
						System.out.println(">재고 전체 목록");
						printProduct(dao.selectAllProduct());
						break;

					case 2:
						System.out.println(">제품명으로 검색");
						System.out.print(">상품명 입력(부분검색가능): ");
						proName = sc.next();
						printProduct(dao.selectProductByName(proName));
						break;

					case 3:
						System.out.println(">TV재고 목록");
						printProduct(dao.selectTVOrRef(1));
						break;

					case 4:
						System.out.println(">냉장고재고 목록");
						printProduct(dao.selectTVOrRef(2));
						break;

					case 5:
						System.out.println(">상품 가격검색(입력이하)");
						System.out.print(">적용 할 가격 입력: ");
						int money = sc.nextInt();
						sc.nextLine();
						printProduct(dao.selectUnderPrice(money));
						break;

					case 0:
						System.out.println("초기화면으로 돌아갑니다.");
						break;
					}
					if (readMenu == 0)
						break;
				}
				break; // end read

			case 3: // Update
				System.out.println(">재고품목 금액변경");
				System.out.print(">상품 번호 입력: ");
				proNum = sc.nextInt();
				sc.nextLine();
				System.out.print(">상품 금액 입력: ");
				proPrice = sc.nextInt();
				sc.nextLine();
				if (dao.updateProduct(proNum, proPrice) > 0)
					System.out.println("제품번호 " + proNum + "번을" + String.format("%,d원으로 가격을 변경하였습니다.", proPrice));
				else
					System.out.println("변경 실패!");
				break; // end Update

			case 4: // Delete
				System.out.println(">상품번호로 삭제");
				System.out.print(">상품 번호 입력: ");
				proNum = sc.nextInt();
				sc.nextLine();

				if (dao.deleteProduct(proNum) > 0)
					System.out.println("제품번호 " + proNum + " 삭제완료");
				else
					System.out.println("삭제 실패!");
				break; // end Delete

			case 0:
				System.out.println("프로그램을 종료합니다.");
				dao.endProgram();
				break;

			}
			if (menu == 0)
				break;

		}
		sc.close();

	}

	public static void main(String[] args) {
		new ProductTest();

	}

}
