package lab.ssafy.corona.virus;

public class SamTest {
	SamTest() {
		System.out.println("created");
		SSub ss = new SSub();
		ss.print();
	}

	class SSSuper{
		int num = -1;

	}
	class SSuper extends SSSuper{
		int num = 100;
	}

	class SSub extends SSuper {
		int num = 10;
		void print() {
			int num = 1;
			System.out.println("print: " + num);
			System.out.println("print: " + this.num);
			System.out.println("print: " + super.num);
			System.out.println("print: " + new SSSuper().num);
		}

	}

	public static void main(String[] args) {
		SamTest st = new SamTest();
		System.out.println(10>>>2);
	}
}

