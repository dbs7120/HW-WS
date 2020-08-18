package d0818;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class GsonTest {

	public static void main(String[] args) {
		new GsonTest();
	}

	public GsonTest() {
		Person person = new Person("홍길동", 25);
		Gson gson = new Gson();
		String jsonStr = gson.toJson(person); // JSON making
		System.out.println(jsonStr);

		// JSON Parsing
		Person p1 = gson.fromJson(jsonStr, Person.class); // 클래스의 원형 : .class
		System.out.println(p1);

		// JSON List making
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("A", 1));
		list.add(new Person("B", 3));
		list.add(new Person("C", 2));
		list.add(new Person("D", 4));
		String jsonListStr = gson.toJson(list);
		System.out.println(jsonListStr);


		// JSON 상태 추가
		PersonResult personResult = new PersonResult();
		personResult.list = list;
		personResult.size = list.size();
		personResult.status = "SUCCESS";
		String jsonListStr2 = gson.toJson(personResult);
		System.out.println(jsonListStr2);

		PersonResult result = gson.fromJson(jsonListStr2, PersonResult.class);
		System.out.println(result.size);
		System.out.println(result.status);
		System.out.println(result.list);
	}

	class PersonResult {
		String status;
		int size;
		List<Person> list;



	}

	class Person {
		private String name;
		private int age;

		public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + "]";
		}

	}

}
