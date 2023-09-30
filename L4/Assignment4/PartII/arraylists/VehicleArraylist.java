package arraylists;

import java.util.ArrayList;
import vehicles.*;


public class VehicleArraylist {

	public static void main(String[] args) {
		// this ArrayList MUST be parameterized
		ArrayList<Vehicle> vehiclesArrayList = new ArrayList<>();
		
		// this is the variable you should retain to compare
		// to the other objects in the ArrayList
		vehiclesArrayList.add(new MotorCycle("red", new String[] {"grip warmers", "usb chargers"}));
		for(int i=0;i<2;i++) vehiclesArrayList.add(new Car("blue", 20, 4));
		vehiclesArrayList.add(new Bicycle("black", false));
		for(int i=0;i<2;i++) vehiclesArrayList.add(new CargoCycle(3, "green", 10, false));
		vehiclesArrayList.add(new Car("gray", 10, 2));
		vehiclesArrayList.add(new Car("white", 25, 4));
		// Initial status of the vehiclesArrayList
		System.out.println("Printing out the Initial status of the vehiclesArrayList");
		for(Vehicle v: vehiclesArrayList) {
			System.out.println(v.toString());
		}
		double totalCargoSpaceCar = 0;
		double totalCars = 0;
		for(Vehicle v: vehiclesArrayList) {
			if(v instanceof Car) {
				totalCargoSpaceCar += v.getCargoSpace();
				totalCars++;
			}
		}
		System.out.println("\nII.b The avg cargo space of all the cars in vehiclesArrayList: " + totalCargoSpaceCar/totalCars);
		// Search for the first occurrence of
		Vehicle car;
		for(Vehicle v: vehiclesArrayList) {
			if(v instanceof Car && ((Car) v).getDoors() == 4 && v.getCargoSpace() == 20.) {
				car = v;
				// print out toString and same variable
				System.out.println("\nII.c Refrence car found: " + car.toString());
				for(Vehicle k: vehiclesArrayList) {
					if(k.equals(car)) {
						System.out.println("\nII.c Matching car found: " + k.toString());
					}
				}
				// Delete all objects same as stored
				vehiclesArrayList.removeIf(s -> s.equals(car));
				break;
			}
		}
		// Finally print out remaining objects
		System.out.println("\nII.d Printing out the remaining objects in the ArrayList");
		for(Vehicle v: vehiclesArrayList) {
			System.out.println(v.toString());
		}
	}

}
