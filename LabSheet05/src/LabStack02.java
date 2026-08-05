import java.util.Stack;

public class LabStack02 {

    public static void main(String[] args) {

        Stack<Integer> track = new Stack<>();

        for (int i = 1; i <= 5; i++) {
            track.push(i);
            System.out.println("Push in track : " + i);
        }

        System.out.println("Train car after into dead-end track : " + track);
        System.out.println();

        while (!track.isEmpty()) {
            System.out.println("Pop from track: " + track.pop());
        }

        System.out.println("Train car after out of dead-end track : " + track);
    }
}
