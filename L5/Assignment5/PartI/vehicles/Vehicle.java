package vehicles;


public class Vehicle {

	private int wheels;
	private String color;
	private double cargoSpace;
	private static int nextId = 1;
	private int id = nextId++;

	public Vehicle() {}

	public Vehicle(int wheels, String color, double cargoSpace) throws VehicleException {
		this.setWheels(wheels);
		this.setCargoSpace(cargoSpace);
		this.setColor(color);
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) throws VehicleException {
		if(wheels < 2) throw new VehicleException("Vehicle cannot have less than 2 wheels!");
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

	public void setCargoSpace(double cargoSpace) throws VehicleException {
		if(cargoSpace < 0) throw new VehicleException("Cargo space cannot be negative!");
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
