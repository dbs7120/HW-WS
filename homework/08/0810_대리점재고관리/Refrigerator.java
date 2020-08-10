package d0810.Product;

public class Refrigerator extends Product {
	private int capacity;
	private int doors;

	public Refrigerator() {
		super();
	}

	public Refrigerator(int proNum, String proName, int proPrice, int proAmount, int capacity, int doors) {
		super(proNum, proName, proPrice, proAmount);
		this.capacity = capacity;
		this.doors = doors;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	@Override
	public String toString() {
		return "제품번호: " + super.getProNum() + " | 제품이름: " + super.getProName() + " | 제품가격: "
				+ String.format("%,d원", super.getProPrice()) + " | 보유수량: " + super.getProAmount() + " | 용량: " + this.capacity
				+ " | 도어갯수: " + this.doors;
	}

}
