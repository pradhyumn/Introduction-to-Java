package university;

public class Affiliate extends Person {

	public Affiliate() {}

	public Affiliate(int age) {
		super(age);
	}

	public String getParamString() {
		return super.getParamString();
	}

	public String toString() {
		return "Affiliate[" + this.getParamString() + "]";
	}

	public boolean equals(Object obj) {
		return obj instanceof Affiliate && ((Affiliate) obj).getAge() == this.getAge();
	}
}
