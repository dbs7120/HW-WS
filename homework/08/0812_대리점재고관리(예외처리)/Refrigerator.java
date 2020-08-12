package d0812.Product;

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
		return "냉장고\t| " + super.toString() + "\t| 용량: " + this.capacity + "\t| 도어갯수: " + this.doors;
	}

}
