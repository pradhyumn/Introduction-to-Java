package university;

import java.util.ArrayList;
import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		// test cases for undergrad student
		System.out.println("\nRunning test case for Undergrad\n");
		Student s1 = new UndergraduateStudent(19, "Chem", true);
		Student s2 = new UndergraduateStudent(19, "Chem", true);
		Student s3 = new UndergraduateStudent(19, "Chem", false);
		Student s4 = new UndergraduateStudent(20, "Chem", true);
		System.out.println("s1 == s2: " + s1.equals(s2) + ", s2 == s3: " + s2.equals(s3) + ", s3 == s4: " + s3.equals(s4));
		System.out.println(s1.toString());
		// test cases for graduate student
		System.out.println("\nRunning test case for Grad\n");
		Student s5 = new GraduateStudent(19, "CompSci", true);
		Student s6 = new GraduateStudent(19, "CompSci", true);
		Student s7 = new GraduateStudent(19, "CompSci", false);
		Student s8 = new GraduateStudent(20, "Phy", true);
		System.out.println("s5 == s6: " + s5.equals(s6) + ", s6 == s7: " + s6.equals(s7) + ", s7 == s8: " + s7.equals(s8));
		System.out.println(s5.toString());
		// test case for faculty
		System.out.println("\nRunning test case for Faculty\n");
		Employee e1 = new Faculty(30, 100000, "Chem", true);
		Employee e2 = new Faculty(30, 100000, "Chem", true);
		Employee e3 = new Faculty(31, 50000, "Phy", false);
		System.out.println("e1 == e2: " + e1.equals(e2) + ", e2 == e3: " + e2.equals(e3));
		System.out.println(e1.toString());
		// test case for staff
		System.out.println("\nRunning test case for Staff\n");
		Employee st1 = new Staff(30, 100000);
		Employee st2 = new Staff(30, 100000);
		Employee st3 = new Staff(31, 50000);
		System.out.println("st1 == st2: " + st1.equals(st2) + ", st2 == st3: " + st2.equals(st3));
		System.out.println(st1.toString());
		// test case for affiliates
		System.out.println("\nRunning test case for Affiliate\n");
		Affiliate a1 = new Affiliate(10);
		Affiliate a2 = new Affiliate(10);
		Affiliate a3 = new Affiliate(11);
		System.out.println("a1 == a2: " + a1.equals(a2) + ", a2 == a3: " + a2.equals(a3));
		System.out.println(a1.toString());
		// test printPersons
		System.out.println("\nRunning test case for Person.printPersons\n");
		ArrayList<Person> personList = new ArrayList<>(Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8,e1,e2,e3,st1,st2,st3,a1,a2,a3));
		Person.printPersons(personList);
	}

}
