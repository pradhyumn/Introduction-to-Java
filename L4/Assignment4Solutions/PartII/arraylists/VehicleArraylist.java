package arraylists;
import java.util.ArrayList;

import vehicles.*;

public class VehicleArraylist {

	public static void main(String[] args) {
		// this ArrayList MUST be parameterized
		ArrayList<Vehicle> vehiclesArrayList = new ArrayList<>();
			
		// this is the variable you should retain to compare
		// to the other objects in the arraylist
		String[] accessories =  {"grip warmers", "usb charger"};
		
		Motorcycle m = new Motorcycle( accessories, "red");
		
		Car blueCar = new Car(4, "blue", 20);
		Car blueCar2 = new Car(4, "blue", 20);
		Bicycle b = new Bicycle(false, "black");
		CargoCycle c = new CargoCycle(3, 10);
		CargoCycle c1 = new CargoCycle(3, 10);
		Car grayCar = new Car(2, "gray", 10);
		Car whiteCar = new Car(4, "white", 25);
		vehiclesArrayList.add(m);
		vehiclesArrayList.add(blueCar);
		vehiclesArrayList.add(blueCar2);
		vehiclesArrayList.add(b);
		vehiclesArrayList.add(c);
		vehiclesArrayList.add(c1);
		vehiclesArrayList.add(grayCar);
		vehiclesArrayList.add(whiteCar);
		double totalCargoSpace = 0;
		for (Vehicle v: vehiclesArrayList) {
			totalCargoSpace += v.getCargoSpace();
		}
		System.out.println("length of vehicles array list is " + vehiclesArrayList.size());
		double averageCargoSpace = totalCargoSpace/vehiclesArrayList.size();
		System.out.println("average cargo space is " + averageCargoSpace);
		
		Car carComp;
		ArrayList<Integer> indexes = new ArrayList<>();
		for (int i=0;i<vehiclesArrayList.size();i++) {
			if (blueCar == vehiclesArrayList.get(i)) {
				System.out.println("the 1st blue car is at index " + i);
			}
			if (blueCar.equals(vehiclesArrayList.get(i))) {
				indexes.add(i);
			}
		}
		int count = 0;
		for (Integer i : indexes) {
			vehiclesArrayList.remove(i-count);
			count++;
		}
		System.out.println("after removing 4 door blue cars with 20 cu ft of cargo space, length of vehiclesArrayList is "+ vehiclesArrayList.size());
		for (Vehicle v : vehiclesArrayList) {
			System.out.println(v);
		}
		
	}

}
