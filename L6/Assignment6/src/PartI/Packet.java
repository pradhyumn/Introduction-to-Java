package PartI;

import java.util.PriorityQueue;


public class Packet implements Comparable<Packet> {

	private Byte[] payload;
	private int priority;

	public Packet(Byte[] payload, int priority) {
		// figure out how this works
		this.setPayload(payload);
		this.setPriority(priority);
	}

	@Override
	public String toString() {
		return "<Packet(priority=" + this.getPriority() + ", payload=" + this.getPayload() + ")>";
	}

	public Byte[] getPayload() {
		return payload;
	}

	public void setPayload(Byte[] payload) {
		this.payload = payload;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public int compareTo(Packet o) {
		return o.getPriority() - this.getPriority();
	}

	public static void main(String[] args) {
        PriorityQueue<Packet> pq = new PriorityQueue<>();

        for (int i = 0; i < 10; i++) {
            Byte[] payload = new Byte[256];
            int priority = (int) (Math.random() * 5) + 1;
            Packet p = new Packet(payload, priority);
            System.out.println("Inserting to priority queue" + p);
            pq.offer(p);
        }

        while (!pq.isEmpty()) {
            System.out.println("got packet " + pq.poll());
        }
    }
}
