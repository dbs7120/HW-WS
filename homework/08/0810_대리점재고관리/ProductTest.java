package d0810.Product;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		ProductMgr mgr = ProductMgr.getInstance();
		Scanner sc = new Scanner(System.in);
		int menu;

		mgr.add(new TV(1000, "삼성전자 시리즈 8", 549000, 3, 43, "UHD"));
		mgr.add(new TV(2000, "LG전자 75UM", 1768420, 2, 75, "UHD"));
		mgr.add(new TV(3000, "삼성전자 시리즈 Q", 2649020, 5, 75, "UHD"));

		mgr.add(new Refrigerator(4000, "LG전자 디오스", 1821590, 2, 870, 4));
		mgr.add(new Refrigerator(5000, "삼성전자 비스포크", 1704750, 1, 871, 4));

		while (true) {
			System.out.println("<<< Abc디지털 대리점 재고관리 >>>");
			System.out.println("1. 상품저장");
			System.out.println("2. 상품리스트 출력");
			System.out.println("3. 상품번호로 검색");
			System.out.println("4. 상품명으로 검색");
			System.out.println("5. 보유중인 TV확인");
			System.out.println("6. 보유중인 냉장고확인");
			System.out.println("7. 상품번호로 삭제");
			System.out.println("8. 재고품목 금액 확인");
			System.out.println("0. 종료");
			menu = sc.nextInt();
			sc.nextLine();

			String proName;
			int proNum, proPrice, proAmount;

			switch (menu) {

			case 1:
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

					mgr.add(new TV(proNum, proName, proPrice, proAmount, inch, resolution));
				} else {
					int capacity, doors;
					System.out.print(">냉장고 용량: ");
					capacity = sc.nextInt();
					sc.nextLine();
					System.out.print(">도어 갯수: ");
					doors = sc.nextInt();
					sc.nextLine();
					mgr.add(new Refrigerator(proNum, proName, proPrice, proAmount, capacity, doors));
				}

				break;
			case 2:
				System.out.println(">제고 전체 출력");
				mgr.showAll();
				break;
			case 3:
				System.out.println(">상품번호로 검색");
				System.out.print(">상품 번호 입력: ");
				proNum = sc.nextInt();
				System.out.println(mgr.searchProNum(proNum));
				break;
			case 4:
				System.out.println(">상품명으로 검색");
				System.out.print(">상품명 입력(부분검색가능): ");
				proName = sc.next();
				for (Product e : mgr.searchProName(proName)) {
					if (e != null) {
						System.out.println(e);
					}
				}
				break;

			case 5:
				System.out.println(">TV재고 출력");
				mgr.searchTV();
				break;

			case 6:
				System.out.println(">냉장고재고 출력");
				mgr.searchTV();
				break;

			case 7:
				System.out.println(">상품번호로 삭제");
				System.out.print(">상품 번호 입력: ");
				proNum = sc.nextInt();
				mgr.remove(proNum);
				break;

			case 8:
				System.out.println(">재고품목 금액 확인");
				mgr.totalPrice();
				break;

			case 0:
				System.out.println("프로그램 종료");
				break;

			}

			if (menu == 0)
				break;

		}
		sc.close();

	}

}
