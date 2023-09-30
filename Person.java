package university;

import java.util.ArrayList;


abstract public class Person {

	private static int nextId = 1;
	private int id;
	private int age;

	protected Person() {
		this.id = nextId++;
	}

	protected Person(int age) {
		this();
		this.age = age;
	}

	public int getId() {
        return id;
    }

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getParamString() {
		return "id: " + this.getId() + ", age: " + this.getAge();
	}

	public String toString() {
		return "Person[" + this.getParamString() + "]";
	}

	public static void printPersons(ArrayList<? extends Person> persons) {
		for(Person p: persons) {
			System.out.println(p.toString());
		}
	}
}
