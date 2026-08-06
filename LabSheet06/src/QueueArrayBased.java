
public class QueueArrayBased {
	
	private int[] queue;
	private final int MAX_SIZE = 50;
	private int size;
	
	public QueueArrayBased() {
		queue = new int[MAX_SIZE];
		size = 0;  // no element in queue
	}
	
	public QueueArrayBased(int capacity) {
		queue = new int[capacity];
		size = 0;
	}
	
	public boolean isEmpty() {
        return size == 0;
	}
	
	public boolean isFull() {
		return size == queue.length-1;
	}
	
	public boolean enqueue(int new_element) {
		if (!isFull()) {
			queue[size] = new_element;
			size++;
			return true;
		}
		return false;
	}
	
	public int peek() {
		return !isEmpty() ? queue[0] : -1;
	}

	public int dequeue() {
		if (!isEmpty()) {
			int temp = queue[0];
			for (int i=1; i<size; i++) {
				queue[i-1] = queue[i];
			}
			size--;
			return temp;
		}
		return -1;
	}
}

