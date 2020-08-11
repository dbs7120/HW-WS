package d0811.Product;

public interface IProductMgr {
	void add(Product item);
	void showAll();
	Product searchProNum(int proNum);
	Product[] searchProName(String proName);
	void searchTV();
	void searchRefrigerator();
	void searchOver400LRefrigerator();
	void searchOver50InchTV();
	void changePrice(int proNum, int proPrice);
	void remove(int proNum);
	void totalPrice();


}
