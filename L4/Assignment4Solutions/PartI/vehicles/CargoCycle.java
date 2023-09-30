package vehicles;

public class CargoCycle extends Bicycle {
	// honestly, this is a case study in the inadequacy
	// of object oriented programming. Because a 
	// cargo cycle is clearly a subclass of bicycle,
	// but cargocycles have cargo and can have more
	// than two wheels. but a bicycle has no cargo
	// and always has two wheels. 
	
	
	// what you may want to do is create new, separate fields for 
	// wheels and cargo space and override the getters and setters
	// for those fields
	
	private int wheels;
	private double cargoSpace;
	
	public CargoCycle() {
		
	}
	
	public CargoCycle(int wheels, double cargoSpace) {
		this.setWheels(wheels);
		this.setCargoSpace(cargoSpace);
	}
	
	public CargoCycle(int wheels, double cargoSpace, 
					boolean isElectric, String color) {
		super(isElectric, color);
		this.setWheels(wheels);
		this.setCargoSpace(cargoSpace);
	
	}
	
	/* if we want to go the override method for wheels
	 * and cargospace, this is what we would do:
	 */
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
	
	public int getWheels() {
		return this.wheels;
	}

	public void setCargoSpace(double cargoSpace) {
		this.cargoSpace = cargoSpace;
	}
	
	public double getCargoSpace() {
		return this.cargoSpace;
	}
	
	public boolean equals(Object o) {
		if (o instanceof CargoCycle) {
			CargoCycle c = (CargoCycle)o;
			if (super.equals(o)) {
				// here you might have overriden the wheels and cargospace
				// so we will have to add this to equals
				if ( (this.getWheels() == c.getWheels()) &&
						(this.getCargoSpace() == c.getCargoSpace())) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public String toString() {
		return "CargoCycle [" + super.toString() + ", wheels = "+this.wheels +", cargoSpace = " +this.cargoSpace+"]";
	}
}
