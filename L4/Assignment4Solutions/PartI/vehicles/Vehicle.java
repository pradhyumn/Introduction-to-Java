package vehicles;

public class Vehicle {
	private static int num_vehicles = 0;
	private int id;
	private int wheels;
	private String color;
	private double cargoSpace;
	
	public Vehicle() {
		this.id = num_vehicles++;
	}
	
	public Vehicle(int wheels, String color, double cargoSpace) {
		this();
		this.wheels = wheels;
		this.color = color;
		this.cargoSpace = cargoSpace;
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
		return this.id;		
	}
	
	public boolean equals(Object o) {
		if (o instanceof Vehicle) {
			Vehicle v = (Vehicle)o;
			if ((this.wheels == v.wheels) && (this.cargoSpace == v.cargoSpace)) {
				if  ((this.color == null) && (v.color == null)) {
					return true;
				}
				if ((this.color != null) && (this.color.equals(v.color)) ) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Vehicle [wheels=" + wheels + ", color=" + color + ", cargoSpace=" + cargoSpace + "]";
	}
	
	
}
