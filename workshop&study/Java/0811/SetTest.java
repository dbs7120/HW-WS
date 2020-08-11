package d0811;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		Set<Data> set = new HashSet<Data>();

		System.out.println(set.size());
		set.add(new Data(1, 2, 3));
		System.out.println(set.size());
		set.add(new Data(1, 2, 3));
		System.out.println(set.size());
		System.out.println(set.toString());


		System.out.println("===================");

		Set<String> set2 = new HashSet<String>();
		set2.add("1");
		set2.add("1");
		set2.add("31");
		set2.add("3");
		set2.add("4");
		System.out.println(set2);

		Set<String> set3 = new TreeSet<String>();
		set3.add("1");
		set3.add("1");
		set3.add("31");
		set3.add("3");
		set3.add("4");
		System.out.println(set3);
	}

	static class Data {
		int x;
		int y;
		int cnt;

		public Data(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public boolean equals(Object obj) {
			Data d = (Data) obj;
			return d.x == this.x && d.y == this.y;
		}

		@Override
		public int hashCode() {
			int hash = 7;
			hash = 31 * hash + x;
			hash = 31 * hash + y;
			return hash;
		}

		@Override
		public String toString() {
			return "Data [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}

	}

}
