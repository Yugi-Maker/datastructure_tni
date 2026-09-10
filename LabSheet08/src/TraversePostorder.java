import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

public class TraversePostorder {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createTree1();    // Try to test with createTree2() and createTree3()
		tree.printTree(tree.getRoot(), 0);
		System.out.println();
		System.out.println("Postorder = " + traversal(tree.getRoot()));
	}

	public static ArrayList<Integer> traversal(Node node) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Deque<Node> stack = new ArrayDeque<Node>();
		Queue<Integer> queue = new ArrayDeque<Integer>();

		if (node == null) return list;

		stack.push(node);
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			queue.add(current.data);

			if (current.left != null) {
				stack.push(current.left);
			}
			if (current.right != null) {
				stack.push(current.right);
			}
		}

		Deque<Integer> reverseStack = new ArrayDeque<Integer>();
		while (!queue.isEmpty()) {
			reverseStack.push(queue.poll());
		}
		while (!reverseStack.isEmpty()) {
			list.add(reverseStack.pop());
		}

		return list;
	}
}
