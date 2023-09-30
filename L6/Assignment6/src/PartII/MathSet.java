package PartII;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class MathSet<E> extends HashSet<E> {

	private static final long serialVersionUID = 1L;

	public Set<E> intersection(Set<E> s2) {
		Set<E> res = new HashSet<E>();
		for(E item: this) {
			if(s2.contains(item)) {
				res.add(item);
			}
		}
		return res;
    }
    
    public Set<E> union(Set<E> s2) {
    	Set<E> res = new HashSet<E>(this);
    	for(E item: s2) {
    		res.add(item);
    	}
    	return res;
    }
    
    public <T> Set<Pair<E,T>> cartesianProduct(Set<T> s2) {
    	Set<Pair<E, T>> res = new LinkedHashSet<Pair<E, T>>();
        for (E e : this) {
            for (T t : s2) {
            	// System.out.println(e + "," + t);
                res.add(new Pair<E, T>(e, t));
            }
        }
        return res;
    }


	public static void main(String[] args) {
		// create two MathSet objects of the same type.
		// See if union and intersection works.
		
		// create another MathSet object of a different type
		// calculate the cartesian product of this set with one of the
		// above sets
		MathSet<Integer> s1 = new MathSet<Integer>();
		s1.add(5);
		s1.add(7);
		s1.add(9);
		MathSet<Integer> s2 = new MathSet<Integer>();
		s2.add(5);
		s2.add(7);
		s2.add(4);
		s2.add(6);
		s2.add(8);
		MathSet<Character> s3 = new MathSet<Character>();
		s3.add('A');
		s3.add('B');
		s3.add('C');
		System.out.println(s1.intersection(s2));
		System.out.println(s1.union(s2));
		System.out.println(s1.cartesianProduct(s2));
		System.out.println();
		System.out.println(s1.cartesianProduct(s3));
	}
}
