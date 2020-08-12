package d0812.Product;

public class TV extends Product {
	private int inch;
	private String resolution; // HD,FHD,QHD

	public TV() {
		super();
	}

	public TV(int proNum, String proName, int proPrice, int proAmount, int inch, String resolution) {
		super(proNum, proName, proPrice, proAmount);
		this.inch = inch;
		this.resolution = resolution;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	@Override
	public String toString() {
		return "TV\t| " + super.toString() + "\t| 화면크기: " + this.inch + "\t| 화면해상도: " + this.resolution;
	}

}
