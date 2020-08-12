package d0812.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductTest {

	// ArrayList<Refrigerator>, ArrayList<TV> 출력용
	public static void printProduct(ArrayList<?> in) {
		for (Object e : in) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		IProductMgr mgr = ProductMgrImpl.getInstance(); // 싱글톤 패턴
		Scanner sc = new Scanner(System.in);
		int menu;
		String proName;
		int proNum, proPrice, proAmount;

		// 결과 확인용 sample data init
		try {
			mgr.add(new TV(1000, "삼성전자 시리즈 8", 549000, 3, 43, "UHD"));
			mgr.add(new TV(2000, "LG전자 75UM", 1768420, 2, 75, "UHD"));
			mgr.add(new TV(3000, "삼성전자 시리즈 Q", 2649020, 5, 75, "UHD"));

			mgr.add(new Refrigerator(4000, "LG전자 디오스", 1821590, 2, 870, 4));
			mgr.add(new Refrigerator(5000, "삼성전자 비스포크", 1704750, 1, 871, 4));

		} catch (DuplicateException e) {
			System.out.println(e);
		}

		while (true) { // start program
			System.out.println("<<<____________Abc디지털 대리점 재고관리____________>>>");
			System.out.println("│\t\t1. 상품저장\t\t\t│"); // C
			System.out.println("│\t\t2. 상품목록\t\t\t│"); // R
			System.out.println("│\t\t3. 재고품목 금액변경\t\t\t│"); // U
			System.out.println("│\t\t4. 상품번호로 삭제\t\t\t│"); // D
			System.out.println("│\t\t0. 종료\t\t\t\t│");
			System.out.println("<<<___________________________________________>>>");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {

			case 1: // Create
				System.out.print(">TV는 1번을 냉장고는 2번을 입력하세요: ");
				int category = sc.nextInt();

				if (category != 1 && category != 2) {
					System.out.println("입력값 오류!");
					break;
				}

				System.out.print(">상품 번호: ");
				proNum = sc.nextInt();
				sc.nextLine();

				System.out.print(">상품 이름: ");
				proName = sc.nextLine();

				System.out.print(">상품 가격: ");
				proPrice = sc.nextInt();
				sc.nextLine();

				System.out.print(">상품 수량: ");
				proAmount = sc.nextInt();
				sc.nextLine();

				if (category == 1) {
					int inch;
					String resolution;
					System.out.print(">화면 크기: ");
					inch = sc.nextInt();
					sc.nextLine();
					System.out.print(">화면 해상도: ");
					resolution = sc.nextLine();

					try {
						mgr.add(new TV(proNum, proName, proPrice, proAmount, inch, resolution));
					} catch (DuplicateException e) {
						System.out.println(e);
					}
				} else {
					int capacity, doors;
					System.out.print(">냉장고 용량: ");
					capacity = sc.nextInt();
					sc.nextLine();
					System.out.print(">도어 갯수: ");
					doors = sc.nextInt();
					sc.nextLine();
					try {
						mgr.add(new Refrigerator(proNum, proName, proPrice, proAmount, capacity, doors));
					} catch (DuplicateException e) {
						System.out.println(e);
					}
				}

				break; // end Create

			case 2: // Read
				while (true) {
					System.out.println("1. 상품리스트전체 출력");
					System.out.println("2. 상품번호로 검색");
					System.out.println("3. 상품명으로 검색");
					System.out.println("4. 보유중인 TV확인");
					System.out.println("5. 보유중인 50인치 이상 TV확인");
					System.out.println("6. 보유중인 냉장고확인");
					System.out.println("7. 보유중인 400L이상 냉장고확인");
					System.out.println("8. 재고품목 금액 확인");
					System.out.println("0. 뒤로가기");

					int readMenu = sc.nextInt();
					sc.nextLine();

					switch (readMenu) {

					case 1:
						System.out.println(">재고 전체 목록");
						try {
							printProduct(mgr.showAll());
						} catch (ProductNotFoundException e) {
							System.out.println(e);
						}
						break;
					case 2:
						System.out.println(">상품번호로 검색");
						System.out.print(">상품 번호 입력: ");
						proNum = sc.nextInt();
						try {
							System.out.println(mgr.searchProNum(proNum));
						} catch (CodeNotFoundException e) {
							System.out.println(e);
						}
						break;
					case 3:
						System.out.println(">상품명으로 검색");
						System.out.print(">상품명 입력(부분검색가능): ");
						proName = sc.next();
						try {
							printProduct(mgr.searchProName(proName));
						} catch (ProductNotFoundException e) {
							System.out.println(e);
						}
						break;
					case 4:
						System.out.println(">TV재고 목록");
						try {
							printProduct(mgr.searchTV());
						} catch (ProductNotFoundException e) {
							System.out.println(e);
						}
						break;
					case 5:
						System.out.println(">50인치 이상 TV목록");
						try {
							printProduct(mgr.searchOver50InchTV());
						} catch (ProductNotFoundException e) {
							System.out.println(e);
						}
						break;
					case 6:
						System.out.println(">냉장고재고 목록");
						try {
							printProduct(mgr.searchRefrigerator());
						} catch (ProductNotFoundException e) {
							System.out.println(e);
						}
						break;
					case 7:
						System.out.println(">400L 이상 냉장고목록");
						try {
							printProduct(mgr.searchOver400LRefrigerator());
						} catch (ProductNotFoundException e) {
							System.out.println(e);
						}

						break;
					case 8:
						System.out.println(">재고품목 금액 확인");
						int result = mgr.totalPrice();
						System.out.println("총 금액합계는 " + String.format("%,d원입니다.", result));
						break;
					case 0:
						System.out.println("초기화면으로 돌아갑니다.");
						break;

					}

					if (readMenu == 0)
						break;

				}

				break; // end Read

			case 3: // Update
				System.out.println(">재고품목 금액변경");
				System.out.print(">상품 번호 입력: ");
				proNum = sc.nextInt();
				sc.nextLine();
				System.out.print(">상품 금액 입력: ");
				proPrice = sc.nextInt();
				sc.nextLine();
				try {
					mgr.changePrice(proNum, proPrice);
					System.out.println("제품번호 " + proNum + "번을" + String.format("%,d원으로 가격을 변경하였습니다.", proPrice));
				} catch (CodeNotFoundException e) {
					System.out.println(e);
				}
				break; // end Update

			case 4: // Delete
				System.out.println(">상품번호로 삭제");
				System.out.print(">상품 번호 입력: ");
				boolean isRemove = false;
				proNum = sc.nextInt();
				sc.nextLine();
				try {
					isRemove = mgr.remove(proNum);
					if (isRemove)
						System.out.println("제품번호 " + proNum + " 삭제완료");
				} catch (CodeNotFoundException e) {
					System.out.println(e);
				}
				break; // end Delete

			case 0:
				System.out.println("프로그램 종료");
				break;

			}
			if (menu == 0)
				break;

		} // end program
		sc.close();

	}

}
