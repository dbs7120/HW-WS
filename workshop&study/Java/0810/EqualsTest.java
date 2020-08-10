package lab.ssafy.corona.virus;

public class EqualsTest {

	public static void main(String[] args) {
		Student d1 = new Student();
		Student d2 = new Student();
		d1.hakbun = 10;
		d2.hakbun = 10;
		System.out.println(d1 == d2);
		System.out.println(d1.hakbun == d2.hakbun);
		System.out.println(d1.equals(d2));

	}

	static class Student extends Object {
		int hakbun;


		// 오버라이딩
		@Override
		public boolean equals(Object obj) {

			return this.hakbun == ((Student) obj).hakbun ? true : false;
		}

	}

}
