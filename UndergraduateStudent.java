package university;

public class UndergraduateStudent extends Student {

	private boolean isMatriculated;

	public UndergraduateStudent() {}

	public UndergraduateStudent(int age, String department, boolean isMatriculated) {
		super(age, department);
		this.isMatriculated = isMatriculated;
	}

	public boolean isMatriculated() {
		return isMatriculated;
	}

	public void setMatriculated(boolean isMatriculated) {
		this.isMatriculated = isMatriculated;
	}

	public String getParamString() {
		return super.getParamString() + ", isMatriculated: " + this.isMatriculated();
	}

	public String toString() {
		return "UndergraduateStudent[" + this.getParamString() + "]";
	}

	public boolean equals(Object o) {
		return o instanceof UndergraduateStudent &&
				((UndergraduateStudent) o).getDepartment() != null && this.getDepartment() != null &&
				((UndergraduateStudent) o).getAge() == this.getAge() &&
				((UndergraduateStudent) o).getDepartment().equalsIgnoreCase(this.getDepartment()) &&
				((UndergraduateStudent) o).isMatriculated() == this.isMatriculated();
	}
}
