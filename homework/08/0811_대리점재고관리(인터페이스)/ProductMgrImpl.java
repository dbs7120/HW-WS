package d0811.Product;

import java.util.ArrayList;

public class ProductMgrImpl implements IProductMgr {
	private ArrayList<Product> products = new ArrayList<Product>();

	static ProductMgrImpl promgr = null;

	private ProductMgrImpl() {
	}

	static ProductMgrImpl getInstance() {
		if (promgr == null) {
			promgr = new ProductMgrImpl();
		}
		return promgr;
	}

	@Override
	// 상품 추가
	public void add(Product item) {
		if (item instanceof TV) { // TV
			TV tv = new TV(item.getProNum(), item.getProName(), item.getProPrice(), item.getProAmount(),
					((TV) item).getInch(), ((TV) item).getResolution());
			products.add(tv);
		} else if (item instanceof Refrigerator) { // 냉장고
			Refrigerator refrigerator = new Refrigerator(item.getProNum(), item.getProName(), item.getProPrice(),
					item.getProAmount(), ((Refrigerator) item).getCapacity(), ((Refrigerator) item).getDoors());
			products.add(refrigerator);
		} else {
			System.out.println("ERROR");
		}

	}

	@Override
	// 상품 전체 목록
	public void showAll() {
		if (products.isEmpty()) {
			System.out.println("저장된 상품이 없습니다.");
			return;
		}
		for (Product e : products) {
			if (e != null)
				System.out.println(e.toString());
		}

	}

	@Override
	// 상품번호로 검색
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

	@Override
	// 부분문자로 상품검색
	public Product[] searchProName(String proName) {
		boolean check = false;
		Product[] temp = new Product[100];
		int cnt = 0;
		for (Product e : products) {
			if (e == null)
				break;
			if (e.getProName().contains(proName)) { // 문자열 부분 검색
				temp[cnt] = e;
				cnt++;
				check = true;
			}

		}
		return check ? temp : null;

	}

	@Override
	public void searchTV() {
		boolean check = false;
		for (Product e : products) {
			if (e instanceof TV) {
				System.out.println(e.toString());
				check = true;
			}

		}
		if (!check)
			System.out.println("TV가 존재하지 않습니다.");

	}

	@Override
	public void searchRefrigerator() {
		boolean check = false;
		for (Product e : products) {
			if (e instanceof Refrigerator) {
				System.out.println(e.toString());
				check = true;
			}

		}
		if (!check)
			System.out.println("냉장고가 존재하지 않습니다.");

	}

	@Override
	public void remove(int proNum) {
		boolean check = false;
		for (Product e : products) {
			if (e.getProNum() == proNum) {
				products.remove(e);
				check = true;
				System.out.println("제품번호 " + proNum + " 삭제완료");
				break;
			}
		}
		if (!check)
			System.out.println("해당 제품번호가 존재하지 않습니다.");
	}

	@Override
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

	@Override
	public void searchOver400LRefrigerator() {
		boolean check = false;
		for (Product e : products) {
			if (e instanceof Refrigerator && ((Refrigerator) e).getCapacity() >= 400) {
				System.out.println(e.toString());
				check = true;
			}

		}
		if (!check)
			System.out.println("400L이상인 냉장고가 없습니다.");

	}

	@Override
	public void searchOver50InchTV() {
		boolean check = false;
		for (Product e : products) {
			if (e instanceof TV && ((TV) e).getInch() >= 50) {
				System.out.println(e.toString());
				check = true;
			}
		}
		if (!check)
			System.out.println("50인치이상인 TV가 존재하지 않습니다.");

	}

	@Override
	public void changePrice(int proNum, int proPrice) {
		boolean check = false;
		for (Product e : products) {
			if (e.getProNum() == proNum) {
				e.setProPrice(proPrice);
				check = true;
				System.out.println("제품번호 " + proNum + "번을" + String.format("%,d원으로 가격을 변경하였습니다.", proPrice));
				break;
			}
		}
		if (!check)
			System.out.println("해당 제품번호가 존재하지 않습니다.");

	}

}
