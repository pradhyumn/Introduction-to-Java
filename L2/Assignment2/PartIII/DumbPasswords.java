import java.util.*;


public class DumbPasswords {
	public static void printDumbPasswords(int m, int n) {
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < m; j++) {
				for(char p = 'a'; (int) p <= n + 96; p++) {
					for(char q = 'a'; (int) q <= n + 96; q++) {
						for(int x = Math.max(i, j) + 1; x <= m; x++) {
							System.out.println(
									String.valueOf(i) + String.valueOf(j) + String.valueOf(p) + String.valueOf(q) + String.valueOf(x));
						}
					}
				}
			}
		}
	}
	public static void main(String args[]) {
		System.out.print("Enter m: ");
		Scanner in = new Scanner(System.in);
		String mInput = in.nextLine();
		int m = Integer.parseInt( mInput );
		System.out.print("Enter n: ");
		String nInput = in.nextLine();
		int n = Integer.parseInt( nInput );
		
		printDumbPasswords(m, n);
	}
}
