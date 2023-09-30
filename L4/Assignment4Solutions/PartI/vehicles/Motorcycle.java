package vehicles;

import java.util.Arrays;

public class Motorcycle extends Vehicle {
	String[] accessories;
	
	public Motorcycle() {
		super(2, null, 0);
		accessories = null;
	}
	
	public Motorcycle(String[] accessories) {
		this();
		this.accessories = accessories;
	}
	
	public Motorcycle(String[] accessories, String color) {
		super(2,color,0);
		this.accessories = accessories;
	}
	
	public String twistThrottle() {
		return "accelerating";
	}
	
	public String[] getAccessories() {
		return this.accessories;
	}
	
	public void setWheels(int wheels) {
		super.setWheels(2);
	}
	
	public boolean equals(Object o) {
		if (o instanceof Motorcycle) {
			Motorcycle m = (Motorcycle)o;
			if (super.equals(o)) {
				Arrays.sort(this.accessories);
				Arrays.sort(m.accessories);
				if (this.accessories.length == m.accessories.length) {
					for (int i=0;i<this.accessories.length;i++) {
						if (!this.accessories[i].equals(m.accessories[i])) {
							return false;
						}
					}
					return true;
				}
			}
		}
		return false;
	}
	

	public String toString() {
		return "Motorcycle [" + super.toString() + ", accessories = " + Arrays.toString(accessories) + "]";
	}
	
}
