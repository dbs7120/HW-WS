package d0807;

import java.util.Arrays;
import java.util.Comparator;

public class test {

	public static void main(String[] args) {
		Student[] students = new Student[5];
		students[0] = new Student(3, 50);
		students[1] = new Student(7, 60);
		students[2] = new Student(4, 60);
		students[3] = new Student(1, 100);
		students[4] = new Student(6, 60);

		// 정렬전
		System.out.println(Arrays.toString(students));

		// 람다식, 점수 내림차순
		Arrays.sort(students, Comparator.comparingInt(Student::getScore).reversed());
		System.out.println(Arrays.toString(students));

		// 람다식, 점수 내림차순, 점수가 같을시 번호의 오름차순으로 (2차 sort)
		Arrays.sort(students, Comparator.comparingInt(Student::getScore).reversed().thenComparingInt(Student::getNo));
		System.out.println(Arrays.toString(students));
	}

	static class Student {
		int no;
		int score;

		public Student(int no, int score) {
			super();
			this.no = no;
			this.score = score;
		}

		public int getNo() {
			return no;
		}

		public void setNo(int no) {
			this.no = no;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		@Override
		public String toString() {
			return "[no=" + no + ", score=" + score + "]";
		}

	}

}
