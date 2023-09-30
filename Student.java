package university;

public abstract class Student extends Person {

	private String department;

	protected Student() {}

	protected Student(int age, String department) {
		super(age);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getParamString() {
		return super.getParamString() + ", department: " + this.getDepartment();
	}

	public String toString() {
		return "Student[" + this.getParamString() + "]";
	}
}
