import java.io.*;
import java.util.ArrayList;

import vehicles.*;

/* your tasks:
 * create a class called VehicleException
 * createVehicle should throw a VehicleException
 * in main(), you should catch the VehicleException
 * 
 */
public class ReadVehicleFile {

	public static Vehicle createVehicle(String vehicleName) throws VehicleException {
		
		if (vehicleName != null && vehicleName.equalsIgnoreCase("Car"))
			return new Car();
		else if(vehicleName != null && vehicleName.equalsIgnoreCase("Bicycle"))
			return new Bicycle();
		else if(vehicleName != null && vehicleName.equalsIgnoreCase("CargoCycle"))
			return new CargoCycle();
		else if(vehicleName != null && vehicleName.equalsIgnoreCase("Motorcycle"))
			return new MotorCycle();
		throw new VehicleException("Cannot create vehicle of type: " + vehicleName);
	}
	
	public static void main(String[] args) {
		ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
		File f = new File("vehicles.txt");

		String inString = null;

		/* create a loop to read the file line-by-line */
		FileReader fr = null;
		try {
			fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			inString = br.readLine();

			while (inString != null) {
				try {
					vehicleList.add(createVehicle((String) inString));
				} catch (VehicleException ve) {
					System.err.println("Cannot create Vehicle: " + inString);
				}
				inString = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Exception: " + e.getMessage());
		}
		System.out.println(
				"Created vehicleList of length: " + vehicleList.size() + ", The contents: " + vehicleList);
	}
}
