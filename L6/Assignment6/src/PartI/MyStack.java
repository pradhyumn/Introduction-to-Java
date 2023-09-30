package PartI;
import java.util.ArrayList;
import java.util.EmptyStackException;


public class MyStack<E> {

	private ArrayList<E> ar;

	MyStack() {
		this.ar = new ArrayList<>();
	}

	public boolean empty() {
		return ar.isEmpty();
	}

	public E peek() {
		if(this.empty()) {
			throw new EmptyStackException();
		}
		return ar.get(ar.size() - 1);
	}

	public E pop() {
		if(this.empty()) {
			throw new EmptyStackException();
		}
		return ar.remove(ar.size() - 1);
	}

	public E push(E item) {
		ar.add(item);
		return item;
	}

	public int search(Object o) {
		for(int i=0;i<ar.size();i++) {
			if(ar.get(i).equals(o)) {
				return i;
			}
		}
		return -1;
	}
}
