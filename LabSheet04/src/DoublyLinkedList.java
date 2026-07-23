
public class DoublyLinkedList {
	
	// Attributes in Class DoublyLinkedList
	private Node head;
	private Node tail;
	
	// Default Constructor
	public DoublyLinkedList () {
		this.head = null;
		this.tail = null;
	}
	
	// Method for traverse all nodes
	public String traversal() {
		Node current_node = head;
		String result = "[";
		boolean first = true;
		while (current_node != null) {
			result += (!first ? ", " : "") + current_node.data;
			current_node = current_node.next;
			first = false;
		}
		result += "]";
		return result;
	}

	// Method for inserting at the end of list
	public void insert(Object value) {
		Node new_node = new Node(value);
		
		if (head == null) {
		    head = new_node;
		    tail = new_node;
		} else {
			tail.next = new_node;
			new_node.previous = tail;
			tail = new_node;
		}
		
	}
	
	// Method for inserting at the beginning and specific position
	public void insert(int position, Object value) {
		Node new_node = new Node(value);
		
		if (head == null) {
		    head = new_node;
		    tail = new_node;
		} else if (position==0) {
			new_node.next = head;
			head.previous = new_node;
			head = new_node;
		} else {
			Node current_node = head;
			int current_position = 0;
			while (current_node != null && current_position < position-1) {
				current_node = current_node.next;
				current_position++;
			}
			
			new_node.previous = current_node;
			new_node.next = current_node.next;
			current_node.next.previous = new_node;
			current_node.next = new_node;
		}
	}

	// Method for deleting the last node
	public void remove() {
		if (head == null) {
	        return;
	    }
	    if (head.next == null) {
	        head = null;
	        return;
	    }
	    Node current = head;
	    while (current.next != null) {
	        current = current.next;
	    }
	    current.previous.next = null;
	}
	
	// Method for deleting at the beginning and specific position
	public void remove(int position) {
		 if (head == null || position < 0) {
		        return;
		    }
		    if (position == 0) {
		        head = head.next;
		        if (head != null) {
		            head.previous = null;
		        }
		        return;
		    }
		    Node current = head;
		    int currentPosition = 0;
		    while (current != null && currentPosition < position) {
		        current = current.next;
		        currentPosition++;
		    }
		    if (current == null) {
		        return;
		    }
		    if (current.next != null) {
		        current.next.previous = current.previous;
		    }
		    current.previous.next = current.next;
	}

	// Method for a backward traversal (from the last node to the first node)
	public String backwardTraversal() {
		if (head == null) {
	        return "[]";
	    }

	    Node current = head;

	    // ไปยังโหนดสุดท้าย
	    while (current.next != null) {
	        current = current.next;
	    }

	    String result = "[";

	    while (current != null) {
	        result += current.data;

	        if (current.previous != null) {
	            result += ", ";
	        }

	        current = current.previous;
	    }

	    result += "]";

	    return result;
	}
	
}