package vehicles;


public class Bicycle extends Vehicle {

	private boolean isElectric;

	public Bicycle() {}

	public Bicycle(String color, boolean isElectric) throws VehicleException {
		super(2, color, 0);
		this.setElectric(isElectric);
	}

	public Bicycle(int wheels, String color, double cargoSpace, boolean isElectric) throws VehicleException {
		super(wheels, color, cargoSpace);
		this.setElectric(isElectric);
	}

	public boolean isElectric() {
		return isElectric;
	}

	public void setElectric(boolean isElectric) {
		this.isElectric = isElectric;
	}
	
	public String pedal() {
		return "pedaling";
	}

	public String toString() {
		return super.toString() + ", isElectric: " + this.isElectric(); 
	}

	public boolean equals(Object v) {
		return v instanceof Bicycle
				&& ((Bicycle) v).isElectric() == this.isElectric()
				&& super.equals(v);
	}

}
