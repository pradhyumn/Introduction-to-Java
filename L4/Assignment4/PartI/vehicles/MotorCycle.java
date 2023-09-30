package vehicles;

import java.util.Arrays;

public class MotorCycle extends Vehicle {

	private String[] accessories; 

	public MotorCycle() {}

	public MotorCycle(String color, String[] accessories) {
		super(2, color, 0);
		this.setAccessories(accessories);
	}

	public String[] getAccessories() {
		return accessories;
	}

	public void setAccessories(String[] accessories) {
		this.accessories = accessories;
	}

	public String twistThrottle() {
		return "accelerating";
	}

	public String toString() {
		return super.toString() + ", accessories: " + Arrays.toString(this.getAccessories()); 
	}

	public boolean equals(Object v) {
		return v instanceof MotorCycle
				&& Arrays.equals(((MotorCycle) v).getAccessories(), this.getAccessories())
				&& super.equals(v);
	}

}
