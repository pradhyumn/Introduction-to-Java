package university;

public class GraduateStudent extends Student {

	private boolean isPhd;

	public GraduateStudent() {}

	public GraduateStudent(int age, String department, boolean isPhd) {
		super(age, department);
		this.isPhd = isPhd;
	}

	public boolean isPhd() {
		return isPhd;
	}

	public void setPhd(boolean isPhd) {
		this.isPhd = isPhd;
	}

	public String getParamString() {
		return super.getParamString() + ", isPhd: " + this.isPhd();
	}

	public String toString() {
		return "GraduateStudent[" + this.getParamString() + "]";
	}

	public boolean equals(Object o) {
		return o instanceof GraduateStudent &&
				((GraduateStudent) o).getDepartment() != null && this.getDepartment() != null &&
				((GraduateStudent) o).getAge() == this.getAge() &&
				((GraduateStudent) o).getDepartment().equalsIgnoreCase(this.getDepartment()) &&
				((GraduateStudent) o).isPhd() == this.isPhd();
	}
}
