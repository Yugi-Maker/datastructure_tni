import java.util.LinkedList;
import java.util.Queue;

public class QueueFirstFive {

    public static void main(String[] args) {

        Queue<Integer> n_queue =
                new LinkedList<Integer>();

        for (int i = 101; i <= 110; i++) {
            n_queue.offer(i);
        }

        System.out.println("Queue => " + n_queue);

        int count = 0;

        int size = n_queue.size();

        for (int i = 0; i < size; i++) {

            int value = n_queue.poll();

            if (count < 5) {
                System.out.print(value + " \n");
                count++;
            }

            n_queue.offer(value);
        }

        System.out.println("Queue => " + n_queue);
    }
}
