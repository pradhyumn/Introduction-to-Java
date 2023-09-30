package vehicles;


public class CargoCycle extends Bicycle {

	public CargoCycle() {}

	public CargoCycle(int wheels, String color, double cargoSpace, boolean isElectric) {
		super(wheels, color, cargoSpace, isElectric);
	}

	public String toString() {
		return super.toString(); 
	}
	
	public boolean equals(Object v) {
		return v instanceof CargoCycle && super.equals(v);
	}

}
