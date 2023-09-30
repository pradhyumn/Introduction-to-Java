package vehicles;

public class Bicycle extends Vehicle {

	private boolean isElectric = false;
	
	public Bicycle() {
		super(2, null, 0);
	}
	
	public Bicycle(boolean isElectric) {
		this();
		this.isElectric = isElectric;
	}
	
	public Bicycle(boolean isElectric, String color) {
		super(2, color, 0);
		this.isElectric = isElectric;
	}
	
	public String pedal() {
		return "pedaling";
	}

	public boolean isElectric() {
		return isElectric;
	}

	public void setElectric(boolean isElectric) {
		this.isElectric = isElectric;
	}
	
	/* this could be a way to enforce the number
	 * of wheels, but it makes it hard to subclass
	 * a cargocycle
	 
	public void setWheels(int wheels) {
		// enforce the requirement that 
		// all bicycles have 2 wheels
		super.setWheels(2);
	} 
	*/
	
	/* similarly you may want to enforce that 
	 * there is always 0 cargo space
	 */
	/*
	public void setCargoSpace(int cargoSpace) {
		// enforce the requirement that 
		// all bicycles have 2 wheels
		super.setCargoSpace(0);
	} 
	*/
	
	public boolean equals(Object o) {
		if (o instanceof Bicycle) {
			Bicycle b = (Bicycle)o;
			if (super.equals(o)) {
				if (b.isElectric == this.isElectric) {
					return true;
				}
			}
		}
		return false;
	}

	public String toString() {
		return "Bicycle [" + super.toString() + ", isElectric = " + this.isElectric + "]";
	}
}
