package d0812.Product;

import java.util.ArrayList;

public interface IProductMgr {
	void add(Product item) throws DuplicateException;

	ArrayList<Product> showAll() throws ProductNotFoundException;

	Product searchProNum(int proNum) throws CodeNotFoundException;

	ArrayList<Product> searchProName(String proName) throws ProductNotFoundException;

	ArrayList<TV> searchTV() throws ProductNotFoundException;

	ArrayList<Refrigerator> searchRefrigerator() throws ProductNotFoundException;

	ArrayList<Refrigerator> searchOver400LRefrigerator() throws ProductNotFoundException;

	ArrayList<TV> searchOver50InchTV() throws ProductNotFoundException;

	void changePrice(int proNum, int proPrice) throws CodeNotFoundException;

	boolean remove(int proNum) throws CodeNotFoundException;

	int totalPrice();

}
