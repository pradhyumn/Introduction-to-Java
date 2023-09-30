
public class WireCapacitance {

	public static double pairCapacitance(double l, double d, double a) {
		double absolutePermittivity = 8.85E-12;
		double numerator = Math.PI * absolutePermittivity * l;
		double tmp = d / (2 * a);
		double denominator = Math.log(tmp + Math.sqrt(Math.pow(tmp, 2) - 1));
		double res = numerator / denominator;
		return res;
	}

	public static double calculateWireCapacitance(double l, double a, double d0, double d1) {
		double capacitanceDifferenceInit = pairCapacitance(l, d0, a);
		double capacitanceDifferenceFin = pairCapacitance(l, d1, a);
		double capacitanceDifference = Math.abs(capacitanceDifferenceInit - capacitanceDifferenceFin);
		return capacitanceDifference;
	}
	
	public static void main(String[] args) {
		double wireLength = 0.5;
		double wireRadius = .002053;
		double initialDistance = .01;
		double finalDistance = .005;
		double capacitanceDifference = calculateWireCapacitance(
				wireLength, wireRadius, initialDistance, finalDistance);
		System.out.println("The wires' change in capacity when moved from a distance of "
		 		+  + initialDistance +
		" m to " + finalDistance + "m is " + capacitanceDifference + " farads");
	}
}
