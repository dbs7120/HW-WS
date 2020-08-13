package d0813;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ObjectStreamTest {	// 객체 스트림

	public static void main(String[] args) {
		File target = new File("c:" + File.separator + "SSAFY" + File.separator + "objPerson.dat");
		Person person = new Person("홍길동", 20, "111111-2222222", "hong", "1234");
		try {
			// 객체 저장
//			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(target));
//			oos.writeObject(person);
//			oos.close();

			// 객체 로딩
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(target));
			Object readed = ois.readObject();
			if (readed != null && readed instanceof Person) {
				Person casted = (Person) readed;
				System.out.println(casted);
			}
			ois.close();

			System.out.println("end success");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Person implements Serializable { // Serialize객체 직렬화

	/**
	 *
	 */
	// 고유 넘버가 같으면 같은 객체 다르면 다른 객체, 생략시 컴파일러가 자동생성함
	private static final long serialVersionUID = 6805357900353699422L;
	private String name;
	private int age;
	private transient String ssn; // 객체직렬화, 휘발성변수

	private String test;

	public Person(String name, int age, String ssn, String userId, String userPass) {
		this.name = name;
		this.age = age;
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", ssn=" + ssn + "]";
	}
}


