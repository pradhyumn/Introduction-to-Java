
public class LoopSum {

	public static boolean isEqual(double a, double b) {
		return Math.abs(a - b) < 0.001;
	}

	public static double fact(double i) {
		double sum = 1;
		while(i > 0) {
			sum *= i--;
		}
		return sum;
	}

	public static double expCalculate(double z, double k) {
		return Math.pow(z, k) / fact(k);
	}

	public static void estimateExponential(int z) {
		double actualExpo = Math.pow(Math.E, z);
		double exp = expCalculate(z, 0);
		int i = 1;
		for(; !isEqual(exp, actualExpo); i++) {
			exp += expCalculate(z, i);
		}
		System.out.println("e^" + String.valueOf(z) + " is " + String.valueOf(actualExpo));
		System.out.println("result for " + String.valueOf(i) + " iterations: " + String.valueOf(exp));
		System.out.println(
				"it requires " + String.valueOf(i) + " iterations to estimate e^" + String.valueOf(z) + " within .001\n");
	}
	
	public static void main(String[] args) {	
//		System.out.println("e^2 " + Math.pow(Math.E, 2));
		for(int i = 0; i <= 15; i++) estimateExponential(i);
	}	
}
