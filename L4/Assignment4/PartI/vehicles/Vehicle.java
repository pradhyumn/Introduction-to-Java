package vehicles;


public class Vehicle {

	private int wheels;
	private String color;
	private double cargoSpace;
	private static int nextId = 1;
	private int id;

	public Vehicle() {}

	public Vehicle(int wheels, String color, double cargoSpace) {
		this.wheels = wheels;
		this.color = color;
		this.cargoSpace = cargoSpace;
		this.id = nextId;
		nextId++;
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getCargoSpace() {
		return cargoSpace;
	}

	public void setCargoSpace(double cargoSpace) {
		this.cargoSpace = cargoSpace;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return "Class: " + this.getClass().getSimpleName() + ", id: " + this.getId()
		+ ", wheels: " + this.getWheels() + ", color: " + this.getColor()
		+ ", cargoSpace: " + this.getCargoSpace();
	}

	public boolean equals(Object v) {
		return v instanceof Vehicle
				&& ((Vehicle) v).getWheels() == this.getWheels()
				&& ((Vehicle) v).getColor() == this.getColor()
				&& ((Vehicle) v).getCargoSpace() == this.getCargoSpace();
	}

}
