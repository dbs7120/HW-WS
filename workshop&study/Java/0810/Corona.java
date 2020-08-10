package lab.ssafy.corona.virus;

public class Corona extends Virus {
	private int speradSpeed;

	public Corona(String name, int level, int speradSpeed) {
		super(name, level);	// 부모 생성자, 부모멤버 채우기
		this.speradSpeed = speradSpeed;
	}

	public int getSperadSpeed() {
		return speradSpeed;
	}

	public void setSperadSpeed(int speradSpeed) {
		this.speradSpeed = speradSpeed;
	}

	public void showInfo() {
		// super 생략가능(자동으로 부모로 탐색)
		System.out.println("name : " + getName() + ", speradSpeed : " + this.getSperadSpeed());
		// System.out.println("name : " + super.getName() + ", speradSpeed : " +
		// this.getSperadSpeed());
	}

}
