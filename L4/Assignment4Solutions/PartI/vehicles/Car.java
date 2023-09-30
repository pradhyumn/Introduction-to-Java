package vehicles;

public class Car extends Vehicle {

	private int doors;
	
	public Car() {
		
		super(4, null, 0);
		this.doors = 4;
	}
	
	public Car(String color, double cargoSpace) {
		super(4, color, cargoSpace);
		this.doors = 4;
	}
	
	public Car(int doors, String color, double cargoSpace) {
		super(4, color, cargoSpace);
		if ((doors == 2) || (doors == 4))
			this.doors = doors;
		else {
			this.doors=4;
		}
	}
	
	public String pressGasPedal() {
		return "accelerating";
	}
	
	public int getDoors() {
		return this.doors;
	}
	
	public void setDoors(int doors) {
		if ((doors == 2) || (doors == 4))
			this.doors = doors;
		else {
			this.doors=4;
		}
	}
	
	public boolean equals(Object o) {
		if (o instanceof Car) {
			Car c = (Car)o;
			if (super.equals(o)) {
				if (this.doors == c.doors) {
					return true;
				}
			}
		}
		return false;
	}
	
	public String toString() {
		return "Car [" + super.toString() + ", doors = " + this.doors + "]";
	}
	
}
