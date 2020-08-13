package d0813;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class ObjectStreamSort {

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student(3, 50));
		students.add(new Student(7, 60));
		students.add(new Student(4, 60));
		students.add(new Student(1, 100));
		students.add(new Student(6, 60));

		// 정렬전
		Stream<Student> stream = students.stream();
		print(stream);

		// 점수 오름차순
		stream = students.stream().sorted(Comparator.comparingInt(Student::getScore));
		print(stream);

		// 점수 내림차순
		stream = students.stream().sorted(Comparator.comparingInt(Student::getScore).reversed());
		print(stream);

		// 점수내림차순, 점수같으면 학번 오름차순
		stream = students.stream()
				.sorted(Comparator.comparingInt(Student::getScore).reversed().thenComparingInt(Student::getNo));
		print(stream);
	}

	public static void print(Stream<?> stream) {
		stream.forEach(a -> System.out.print(a + " "));
		System.out.println();
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
