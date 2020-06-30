// Name: Keith Radford
// Student number: V00918086

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
		int index = this.size;
		this.size++;
		this.data[index] = element;
		if(index > 0){
			// Bubble up
			for(int i = index; i > 0; i /= 2){
				if(this.data[i / 2].getFrequency() < this.data[i].getFrequency()){
					Entry tmp = this.data[i / 2];
					this.data[i / 2] = this.data[i];
					this.data[i] = tmp;
				}
				else break;
			}	
		}
	}

	public Entry removeMax() {
		if(this.size > 0){
			this.size--;
			Entry to_ret = this.data[0];
			if(this.size > 0){
				// Set first element to last element
				this.data[0] = this.data[size];
				// Bubble down
				int i = 0;
				while((2 * i) + 1 < size){
					int right = (2 * i) + 2;
					int left = (2 * i) + 1;
					System.out.println("Right" + right + "Left" + left);
					if(this.data[right].getFrequency() > this.data[left].getFrequency()){
						Entry tmp = this.data[right];
						this.data[right] = this.data[i];
						this.data[i] = tmp;
						i = right;
					}
					else if(this.data[right].getFrequency() < this.data[left].getFrequency()){
						Entry tmp = this.data[left];
						this.data[left] = this.data[i];
						this.data[i] = tmp;
						i = left;
					}
					else break;
				}
			}
			return to_ret;
		}
		return null;
	}
	
	public boolean isEmpty() {
		if(size != 0) return false;
		else return true;
	}
	
	public int size() {
		return size;
	}

}
 
