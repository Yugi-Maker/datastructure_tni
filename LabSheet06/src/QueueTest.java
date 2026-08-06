
public class QueueTest {

	public static void main(String[] args) {
		
		QueueArrayBased q = new QueueArrayBased();
		
		q.enqueue(10);
		q.enqueue(11);
		q.enqueue(12);
		
		System.out.println(q.peek());
		System.out.println(q.dequeue());
		System.out.println(q.peek());
		
		
	}
}
