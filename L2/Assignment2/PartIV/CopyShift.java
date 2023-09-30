import java.util.Arrays;

public class CopyShift {

	public static void copyShift(int[] sourceArray, int[] destArray, int shift) {
		shift %= sourceArray.length;
		int desPtr = 0;
		for(int i = sourceArray.length - shift; i < sourceArray.length; i++) {
			destArray[desPtr++] = sourceArray[i];
		}
		for(int i = 0; i < sourceArray.length - shift; i++) {
			destArray[desPtr++] = sourceArray[i];
		}
		
	}
	
	public static void main(String[] args) {
		int[] sourceArray = new int[50];
		int[] destArray = new int[50];
		
		/* initialize the source Array */
		for (int i = 0;i < sourceArray.length; i++) {
			sourceArray[i] = (int)(Math.random()*100);
		}
		
		int shiftValue = 8;
		copyShift(sourceArray, destArray, shiftValue);
		System.out.println("This    is   source array: " + Arrays.toString(sourceArray));
		System.out.println("This is Destination array: " + Arrays.toString(destArray));
	}
}
