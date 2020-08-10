package d0810.Product;

public class ProductMgr {
	private Product[] products = new Product[50];
	private int index = 0;

	static ProductMgr promgr = null;

	private ProductMgr() {
	}

	static ProductMgr getInstance() {
		if (promgr == null) {
			promgr = new ProductMgr();
		}
		return promgr;
	}

	public void add(Product item) {
		if (item instanceof TV) { // TV
			TV tv = new TV(item.getProNum(), item.getProName(), item.getProPrice(), item.getProAmount(),
					((TV) item).getInch(), ((TV) item).getResolution());
			products[index] = tv;
			index++;
		} else if (item instanceof Refrigerator) { // 냉장고
			Refrigerator refrigerator = new Refrigerator(item.getProNum(), item.getProName(), item.getProPrice(),
					item.getProAmount(), ((Refrigerator) item).getCapacity(), ((Refrigerator) item).getDoors());
			products[index] = refrigerator;
			index++;
		} else {
			System.out.println("ERROR");
		}

	}

	public void showAll() {
		if (index == 0) {
			System.out.println("저장된 상품이 없습니다.");
			return;
		}
		for (Product e : products) {
			if (e != null)
				System.out.println(e.toString());
		}

	}

	public Product searchProNum(int proNum) {
		for (Product e : products) {
			if (e == null)
				break;
			if (e.getProNum() == proNum) {
				return e;
			}

		}
		return null;
	}

	public Product[] searchProName(String proName) {
		Product[] temp = new Product[100];
		int cnt = 0;
		for (Product e : products) {
			if (e == null)
				break;
			if (e.getProName().contains(proName)) { // 문자열 부분 검색
				temp[cnt] = e;
				cnt++;
			}

		}
		return temp;
	}

	public void searchTV() {
		boolean check = false;
		for (Product e : products) {
			if (e instanceof TV) { // 부분 검색
				System.out.println(e.toString());
				check = true;
			}

		}
		if (!check)
			System.out.println("TV가 존재하지 않습니다.");

	}

	public void searchRefrigerator() {
		boolean check = false;
		for (Product e : products) {
			if (e instanceof Refrigerator) { // 부분 검색
				System.out.println(e.toString());
				check = true;
			}

		}
		if (!check)
			System.out.println("냉장고가 존재하지 않습니다.");

	}

	public void remove(int proNum) {
		boolean check = false;
		for (int i = 0; i < index; i++) {
			if (products[i].getProNum() == proNum) {
				for (int j = i; j < index; j++) {
					products[j] = products[j + 1];
				}
				index--;
				check = true;
				System.out.println("제품번호 " + proNum + " 삭제완료");
				break;
			}

		}
		if (!check)
			System.out.println("해당 제품번호가 존재하지 않습니다.");

	}

	public void totalPrice() {
		int price = 0;
		int tvCnt = 0, refrigeratorCnt = 0;
		for (Product e : products) {
			if (e == null)
				break;
			price += (e.getProPrice() * e.getProAmount());
			if (e instanceof TV)
				tvCnt++;
			else if (e instanceof Refrigerator)
				refrigeratorCnt++;

		}

		System.out.println("현재 TV: " + tvCnt + "대, 냉장고: " + refrigeratorCnt + "대 보유중");
		System.out.println("총 금액합계는 " + String.format("%,d원입니다.", price));

	}

}
