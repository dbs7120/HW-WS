package d0811.Product;

public class Product {
	private int proNum;
	private String proName;

	private int proPrice;
	private int proAmount;

	public Product() {
		super();
	}

	public Product(int proNum, String proName, int proPrice, int proAmount) {
		super();
		this.proNum = proNum;
		this.proName = proName;

		this.proPrice = proPrice;
		this.proAmount = proAmount;
	}

	public int getProNum() {
		return proNum;
	}

	public void setProNum(int proNum) {
		this.proNum = proNum;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public int getProPrice() {
		return proPrice;
	}

	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}

	public int getProAmount() {
		return proAmount;
	}

	public void setProAmount(int proAmount) {
		this.proAmount = proAmount;
	}

//	@Override
//	public String toString() {
//		return "Product [proNum=" + proNum + ", proName=" + proName + ", proPrice=" + proPrice + ", proAmount="
//				+ proAmount + "]";
//	}

}
