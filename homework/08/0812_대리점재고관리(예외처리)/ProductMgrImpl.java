package d0812.Product;

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
	public void add(Product item) throws DuplicateException {
		for (Product e : products) {
			if (item.getProNum() == e.getProNum()) {
				throw new DuplicateException();
			}
		}
		products.add(item);
	}

	@Override
	// 상품 전체 목록
	public ArrayList<Product> showAll() throws ProductNotFoundException {
		ArrayList<Product> temp = new ArrayList<Product>();
		if (products.isEmpty()) {
			throw new ProductNotFoundException();
		}
		for (Product e : products) {
			temp.add(e);
		}
		return temp;

	}

	@Override
	// 상품번호로 검색
	public Product searchProNum(int proNum) throws CodeNotFoundException {

		boolean check = false;
		Product temp = null;
		for (Product e : products) {
			if (e.getProNum() == proNum) {
				check = true;
				temp = e;
			}
		}
		if (!check)
			throw new CodeNotFoundException();
		return temp;
	}

	@Override
	// 부분문자로 상품검색
	public ArrayList<Product> searchProName(String proName) throws ProductNotFoundException {
		boolean check = false;
		ArrayList<Product> temp = new ArrayList<Product>();
		for (Product e : products) {
			if (e.getProName().contains(proName)) { // 문자열 부분 검색
				temp.add(e);
				check = true;
			}
		}
		if (!check)
			throw new ProductNotFoundException();
		return temp;
	}

	@Override
	// TV목록 반환
	public ArrayList<TV> searchTV() throws ProductNotFoundException {
		ArrayList<TV> temp = new ArrayList<TV>();
		boolean check = false;
		for (Product e : products) {
			if (e instanceof TV) {
				temp.add((TV) e);
				check = true;
			}
		}
		if (!check)
			throw new ProductNotFoundException();
		return temp;
	}

	@Override
	// 50인치 이상 TV반환
	public ArrayList<TV> searchOver50InchTV() throws ProductNotFoundException {
		ArrayList<TV> temp = new ArrayList<TV>();
		boolean check = false;
		for (Product e : products) {
			if (e instanceof TV && ((TV) e).getInch() >= 50) {
				temp.add((TV) e);
				check = true;
			}
		}
		if (!check)
			throw new ProductNotFoundException();
		return temp;
	}

	@Override
	// 냉장고 목록 반환
	public ArrayList<Refrigerator> searchRefrigerator() throws ProductNotFoundException {
		ArrayList<Refrigerator> temp = new ArrayList<Refrigerator>();
		boolean check = false;
		for (Product e : products) {
			if (e instanceof Refrigerator) {
				temp.add((Refrigerator) e);
				check = true;
			}
		}
		if (!check)
			throw new ProductNotFoundException();
		return temp;

	}

	@Override
	// 400L이상 냉장고 반환
	public ArrayList<Refrigerator> searchOver400LRefrigerator() throws ProductNotFoundException {
		ArrayList<Refrigerator> temp = new ArrayList<Refrigerator>();
		boolean check = false;
		for (Product e : products) {
			if (e instanceof Refrigerator && ((Refrigerator) e).getCapacity() >= 400) {
				temp.add((Refrigerator) e);
				check = true;
			}

		}
		if (!check)
			throw new ProductNotFoundException();
		return temp;

	}

	@Override
	// 재고삭제
	public boolean remove(int proNum) throws CodeNotFoundException {
		boolean check = false;
		for (Product e : products) {
			if (e.getProNum() == proNum) {
				products.remove(e);
				check = true;
				return true;
			}
		}
		if (!check)
			throw new CodeNotFoundException();
		return check;
	}

	@Override
	// 총금액 반환
	public int totalPrice() {
		int price = 0;
		for (Product e : products) {
			price += (e.getProPrice() * e.getProAmount());
		}
		return price;

	}

	@Override
	// 금액변경
	public void changePrice(int proNum, int proPrice) throws CodeNotFoundException {
		boolean check = false;
		for (Product e : products) {
			if (e.getProNum() == proNum) {
				e.setProPrice(proPrice);
				check = true;
				break;
			}
		}
		if (!check)
			throw new CodeNotFoundException();

	}

}
