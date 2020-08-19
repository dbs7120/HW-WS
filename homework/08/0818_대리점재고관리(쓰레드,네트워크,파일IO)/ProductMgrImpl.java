package d0818.Product;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

public class ProductMgrImpl implements IProductMgr, Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 4195963410465474180L; // Object IO를위해 Serializable
	File f = new File("product.dat");

	private ArrayList<Product> products = new ArrayList<Product>();

	static ProductMgrImpl promgr = null;

	private ProductMgrImpl() {

		if (f.exists()) {
			inputFile();
		} else { // 파일존재하지않으면 초기 샘플데이터삽입
			try {
				addSample();
				outputFile();
			} catch (DuplicateException e) {
				e.printStackTrace();
			}
		}

	}

	static ProductMgrImpl getInstance() { // SingleTon
		if (promgr == null) {
			promgr = new ProductMgrImpl();
		}
		return promgr;
	}

	@SuppressWarnings("unchecked")
	private void inputFile() { // FileRead
		try (FileInputStream fis = new FileInputStream(f);
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis);) {
			products = (ArrayList<Product>) ois.readObject(); // "unchecked"
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	// 객체파일 저장
	public void outputFile() {
		new Thread(() -> {
			try (FileOutputStream fos = new FileOutputStream(f);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					ObjectOutputStream oos = new ObjectOutputStream(bos);) {
				oos.writeObject(products);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start(); // end run

	}

	@Override
	// 서버 전송
	public void sendToServer() {
		new Thread(() -> {
			try (Socket s = new Socket("127.0.0.1", 8080)) {
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				oos.writeObject(products);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start(); // end run

	}

	// 샘플 추가 (첫 실행시에만 작동)
	private void addSample() throws DuplicateException {
		ArrayList<Product> temp = new ArrayList<Product>();
		temp.add(new Refrigerator(4000, "LG전자 디오스", 1821590, 2, 870, 4));
		temp.add(new TV(1000, "삼성전자 시리즈 8", 549000, 3, 43, "UHD"));
		temp.add(new TV(2000, "LG전자 75UM", 1768420, 2, 75, "UHD"));
		temp.add(new Refrigerator(5000, "삼성전자 비스포크", 1704750, 1, 871, 4));
		temp.add(new TV(3000, "삼성전자 시리즈 Q", 2649020, 5, 75, "UHD"));
		products = temp;
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
		outputFile();
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
				outputFile();
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
				outputFile();
				check = true;
				break;
			}
		}
		if (!check)
			throw new CodeNotFoundException();
	}

}
