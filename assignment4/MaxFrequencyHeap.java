// Name: 
// Student number: V00

public class MaxFrequencyHeap implements PriorityQueue {
	
	private static final int DEFAULT_CAPACITY = 10;
	private Entry[] data;
	private int size;
	
	public MaxFrequencyHeap() {
		data = new Entry[DEFAULT_CAPACITY];
		size = 0;
	}
	
	public MaxFrequencyHeap(int size) {
		data = new Entry[size];
		size = 0;
	}
	
	public void insert(Entry element) {
		// TODO: Complete this method
	}

	public Entry removeMax() { 
		// TODO: Complete this method
		return null; // so it compiles
	}
	
	public boolean isEmpty() {
		// TODO: Complete this method
		return false; // so it compiles
	}
	
	public int size() {
		// TODO: Complete this method
		return 0; // so it compiles
	}

}
 
