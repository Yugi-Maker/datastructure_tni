class Node {
	public int data;
	public Node next;

	public Node(int value) {
		this.data = value;
		this.next = null;
	}
}

public class SinglyLinkedList {
	private Node head;
	private Node tail;

	public SinglyLinkedList() {
		head = null;
		tail = null;
	}

	public String displayList() {
		boolean first = true;
		String display = "[";
		for (Node current = head; current != null; current = current.next) {
			display += (!first ? ", " : "") + current.data;
			first = false;
		}
		display += "]";
		return display;
	}

	public void clear() {
		head = null;
		tail = null;
	}

	public boolean isEmpty() {

		return head == null;
	}

	public void append(int value) {

		Node newNode = new Node(value);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public Object get(int position) {

		if (position < 0) {
			return null;
		}

		Node current = head;
		int index = 0;

		while (current != null) {

			if (index == position) {
				return current.data;
			}

			current = current.next;
			index++;
		}

		return null;
	}

	public void set(int position, int value) {

		if (position < 0) {
			System.out.println("Updated data fail...");
			return;
		}

		Node current = head;
		int index = 0;

		while (current != null) {

			if (index == position) {
				current.data = value;
				System.out.println("Updated data success!!");
				return;
			}

			current = current.next;
			index++;
		}

		System.out.println("Updated data fail...");
	}

	public boolean contains(int value) {

		Node current = head;

		while (current != null) {

			if (current.data == value) {
				return true;
			}

			current = current.next;
		}

		return false;
	}

	public void addAll(SinglyLinkedList otherlist) {

		Node current = otherlist.head;

		while (current != null) {
			append(current.data);
			current = current.next;
		}
	}

}