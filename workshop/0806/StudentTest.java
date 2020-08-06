package d0806;

import java.util.Arrays;
import java.util.Comparator;

public class StudentTest {

	public static void main(String[] args) {
		Student[] students = new Student[5];
		students[0] = new Student(3, 50);
		students[1] = new Student(2, 60);
		students[2] = new Student(4, 60);
		students[3] = new Student(1, 100);
		students[4] = new Student(6, 60);

		// 정렬전
		System.out.println(Arrays.toString(students));

		// 학번 오름차순
		Arrays.sort(students);
		System.out.println(Arrays.toString(students));

		// 점수 내림차순
		Arrays.sort(students, comparator);
		System.out.println(Arrays.toString(students));

	}

	static StudentComparator comparator = new StudentComparator();

	static class StudentComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) { // 점수 내림 차순

			return o2.score - o1.score;
		}

	}

	static class Student implements Comparable<Student> {
		int no;
		int score;

		public Student(int no, int score) {
			super();
			this.no = no;
			this.score = score;
		}

		@Override
		public int compareTo(Student o) {

			return this.no - o.no; // 학번 오름차순
			// return this.no <= o.no ? -1 : 1;
		}

		@Override
		public String toString() {
			return "[no=" + no + ", score=" + score + "]";
		}

	}

}
