package university;

public class Faculty extends Employee {

	private String department;
	private boolean isTenureTrack;

	public Faculty() {}

	public Faculty(int age, double salary, String department, boolean isTenureTrack) {
		super(age, salary);
		this.department = department;
		this.isTenureTrack = isTenureTrack;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public boolean isTenureTrack() {
		return isTenureTrack;
	}

	public void setTenureTrack(boolean isTenureTrack) {
		this.isTenureTrack = isTenureTrack;
	}

	public String getParamString() {
		return super.getParamString() + ", department: " + this.getDepartment() +
				", isTenureTrack: " + this.isTenureTrack();
	}

	public String toString() {
		return "Faculty[" + this.getParamString() + "]";
	}

	public boolean equals(Object o) {
		return o instanceof Faculty &&
				((Faculty) o).getDepartment() != null && this.getDepartment() != null &&
				((Faculty) o).getAge() == this.getAge() &&
				((Faculty) o).getSalary() == this.getSalary() &&
				((Faculty) o).isTenureTrack() == this.isTenureTrack() &&
				((Faculty) o).getDepartment().equalsIgnoreCase(this.getDepartment());
	}
}
