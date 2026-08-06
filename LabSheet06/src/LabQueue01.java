import java.util.ArrayDeque;
import java.util.Queue;

public class LabQueue01 {

    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<Integer>();

        // Enqueue 101-105
        for (int i = 101; i <= 105; i++) {
            queue.offer(i);
            System.out.println("Enqueue: " + i);
        }

        System.out.println("Queue => " + queue);
        System.out.println();

        // Calling and Providing service
        while (!queue.isEmpty()) {
            System.out.println("Calling number: " + queue.peek());
            System.out.println("Providing service number: " + queue.poll());
            System.out.println();
        }

        System.out.println("Queue => " + queue);
    }
}
