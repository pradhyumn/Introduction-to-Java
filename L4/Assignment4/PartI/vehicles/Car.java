package vehicles;


public class Car extends Vehicle {

	private int doors;

	public Car() {}

	public Car(String color, double cargoSpace, int doors) {
		super(4, color, cargoSpace);
		this.setDoors(doors);
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public String pressGasPedal() {
		return "accelerating";
	}

	public String toString() {
		return super.toString() + ", doors: " + this.getDoors(); 
	}

	public boolean equals(Object v) {
		return v instanceof Car
				&& ((Car) v).getDoors() == this.getDoors()
				&& super.equals(v);
	}
}
