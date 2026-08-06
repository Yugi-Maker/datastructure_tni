
public class QueueLinkedList {

	// pointer of the front and rear node
	private Node front;
	private Node rear;
	
	// create an empty queue
	public QueueLinkedList() {
		front = null;
		rear  = null;
	}
	
	public boolean isEmpty() {
		return front == null;
	}
	
	public void enqueue(int value) {
		Node new_node = new Node(value);
		if (isEmpty()) {
			front = new_node;
			rear = new_node;
		} else {
			rear.next = new_node;
			rear = new_node;
		}
	}
	
	public int peek() {
        return !isEmpty() ? front.data : -1;
	}
	
	public int dequeue() {
		if (!isEmpty()) {
			Node temp_node = front;
			int temp_data = temp_node.data;
			
			front = front.next;
			
			temp_node = null;
			
			return temp_data;
		}
		return -1;
	}
	
}


