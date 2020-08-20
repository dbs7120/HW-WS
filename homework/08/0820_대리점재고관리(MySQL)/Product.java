package d0820.Product;

public class Product {
	private int proNum;
	private String proName;
	private String proType;

	private int proPrice;
	private int proAmount;

	public Product() {
		super();
	}

	public Product(int proNum, String proName, String proType, int proPrice, int proAmount) {
		this.proNum = proNum;
		this.proName = proName;
		this.proType = proType;

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

	public String getProType() {
		return proType;
	}

	public void setProType(String proType) {
		this.proType = proType;
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

	@Override
	public String toString() {
		return proType + "\t| 제품번호: " + proNum + "\t| 제품이름: " + proName + "\t| 제품가격: " + String.format("%,d원", proPrice)
				+ "\t| 보유수량: " + proAmount;
	}

}
