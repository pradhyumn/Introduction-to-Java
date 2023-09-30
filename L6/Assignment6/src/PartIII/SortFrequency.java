package PartIII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SortFrequency {

    public static void sortByFrequencyOld(ArrayList<Integer> ar) {
    	/* 
    	 * Q. You may get some numbers that aren’t “sorted”. Explain why.
    	 * Answer - Note that there may be cases where the
    	 * sorted result is not in strictly ascending order.
    	 * This can happen when multiple integers have the same frequency of occurrence.
    	 * In this case, the Collections.sort method will sort those integers based on their natural ordering,
    	 * which may not necessarily be in strictly ascending order.
    	*/
    	Map<Integer, Integer> freqMap = new HashMap<>();

        // count frequency of each integer in the ArrayList
        for (Integer i : ar) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }
        System.out.println(freqMap);
        Collections.sort(ar, (a, b) -> freqMap.get(a) - freqMap.get(b));
    }

    public static void sortByFrequency(ArrayList<Integer> ar) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		// count frequency of each integer in the ArrayList
		for (Integer i : ar) {
		    freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
		}
		System.out.println(freqMap);
		Collections.sort(ar, (a, b) -> {
		    int freqCompare = freqMap.get(a) - freqMap.get(b);
		    if (freqCompare == 0) {
		        return a - b; // tie-break using natural ordering
		    }
		    return freqCompare;
		});
    }

    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<Integer>();
        for (int i=0;i<100;i++) {
                ar.add((int)(Math.random()*10));                        
        }
        System.out.println(ar.toString());
        // where tie-breaker is not handled
        sortByFrequencyOld(ar);
        System.out.println(ar.toString());
        sortByFrequency(ar);
        System.out.println(ar.toString());
    }
}
