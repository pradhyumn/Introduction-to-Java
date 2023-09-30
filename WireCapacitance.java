class WireCapacitance {

	public static double pairCapacitance(double l, double d, double a) {
		double absolutePermittivity = 8.85E-12;
		double numerator = Math.PI * absolutePermittivity * l;
		double tmp = d / (2 * a);
		double denominator = Math.log(tmp + Math.sqrt(Math.pow(tmp, 2) - 1));
		double res = numerator / denominator;
		return res;
	}

	public static void main(String[] arguments) {
		double initialDistance = .01;
		double finalDistance = .005;
		double wireLength = 0.5;
		double wireRadius = .002053;
		double capacitanceDifferenceInit = pairCapacitance(wireLength, initialDistance, wireRadius);
		double capacitanceDifferenceFin = pairCapacitance(wireLength, finalDistance, wireRadius);
		double capacitanceDifference = Math.abs(capacitanceDifferenceInit - capacitanceDifferenceFin);
		System.out.println("The wires' change in capacity when moved from a distance of "
		 		+  + initialDistance +
		" m to " + finalDistance + "m is " + capacitanceDifference + " farads");
	}
}