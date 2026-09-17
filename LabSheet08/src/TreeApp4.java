import java.util.Scanner;

public class TreeApp4 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        BinaryTree tree = new BinaryTree();

        tree.createTree6();

        System.out.println("Binary Tree from createTree6()");
        System.out.println("------------------------------");

        tree.printTree(tree.getRoot(), 0);

        System.out.println();

        System.out.print("Enter N: ");
        int n = input.nextInt();

        Node current = tree.getRoot();

        while (current != null && current.data != n) {

            if (n < current.data) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }

        if (current == null) {

            System.out.println(
                "Cannot found Node(data=[" + n + "])"
            );

            input.close();
            return;
        }

        if (current.left == null) {
            System.out.println("No Left Child");
        }
        else {
            System.out.println(
                "Left Child = " + current.left
            );
        }

        if (current.right == null) {
            System.out.println("No Right Child");
        }
        else {
            System.out.println(
                "Right Child = " + current.right
            );
        }

        if (current.left == null && current.right == null) {

            System.out.println(
                n + " is Leaf Node"
            );

        }
        else {

            System.out.println(
                n + " is not Leaf Node"
            );
        }

        input.close();
    }
}
