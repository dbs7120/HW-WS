package d0806;

import java.util.Arrays;
import java.util.Comparator;

public class StudentTest2 {

	public static void main(String[] args) {
		Student[] students = new Student[5];
		students[0] = new Student(3, 50);
		students[1] = new Student(7, 60);
		students[2] = new Student(4, 60);
		students[3] = new Student(1, 100);
		students[4] = new Student(6, 60);

		// 정렬전
		System.out.println(Arrays.toString(students));


		// 점수 내림차순
		Arrays.sort(students, comparator);
		System.out.println(Arrays.toString(students));

		// 점수 내림차순, 점수가 같을시 번호의 오름차순으로 (2차 sort)
		Arrays.sort(students, new Comparator<Student>() { // 익명 클래스

			@Override
			public int compare(Student o1, Student o2) {
				if (o2.score != o1.score) {
					return o2.score - o1.score;
				} else {
					//return o1.no - o2.no;
					return new Integer(o1.no).compareTo(o2.no);
				}
			}
		});
		System.out.println(Arrays.toString(students));

	}

	static Comparator comparator = new Comparator<Student>() { // 익명 클래스

		@Override
		public int compare(Student o1, Student o2) { // 점수 내림 차순

			return o2.score - o1.score;
		}

	};

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
