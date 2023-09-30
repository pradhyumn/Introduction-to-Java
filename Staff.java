package university;

public class Staff extends Employee {

	public Staff() {}

	public Staff(int age, double salary) {
		super(age, salary);
	}

	public String getParamString() {
		return super.getParamString();
	}

	public String toString() {
		return "Staff[" + this.getParamString() + "]";
	}

	public boolean equals(Object o) {
		return o instanceof Staff &&
				((Staff) o).getAge() == this.getAge() &&
				((Staff) o).getSalary() == this.getSalary();
	}
}
