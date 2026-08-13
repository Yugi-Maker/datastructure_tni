import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class QueueRotate {
    public static Queue<Integer> queue = new ArrayDeque<Integer>();

    public static void main(String[] args) {
        
    	Scanner input = new Scanner(System.in);

        originalQueue();

        while (true) {
            System.out.print("\nPress 1 to rotate queue: ");
            int choice = input.nextInt();

            if (choice == 1) {
                rotateQueue();
            } else {
                System.out.println("Exit");
                break;
            }
        }

        input.close();
    }

    public static void rotateQueue() {
        
    	if (!queue.isEmpty()) {

            int calledNumber = queue.poll();
            System.out.println("Calling queue: " + calledNumber);

            queue.add(calledNumber);
        }
        System.out.println("Queue => " + queue);
    }

    public static void originalQueue() {

        for (int i = 101; i <= 107; i++) {
            queue.add(i);
        }
        System.out.println("Queue => " + queue);
    }
}