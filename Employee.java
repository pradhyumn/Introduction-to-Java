package university;

public abstract class Employee extends Person {

	private double salary;

	protected Employee() {}

	protected Employee(int age, double salary) {
		super(age);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getParamString() {
		return super.getParamString() + ", salary: " + this.getSalary();
	}

	public String toString() {
		return "Employee[" + this.getParamString() + "]";
	}
}
