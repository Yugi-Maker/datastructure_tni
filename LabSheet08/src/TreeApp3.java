
public class TreeApp3 {

	public static void main(String[] args) {
		
		 BinaryTree tree;

	        tree = new BinaryTree();
	        tree.createTree5();

	        System.out.println("Binary Tree from createTree5()");
	        System.out.println("------------------------------");

	        tree.printTree(tree.getRoot(), 0);

	        System.out.println();
	        System.out.println("Delete Leaf Node : 45");

	        tree.delete(45);

	        tree.printTree(tree.getRoot(), 0);

	        tree = new BinaryTree();
	        tree.createTree5();

	        System.out.println();
	        System.out.println("Delete Node with 1 Child : 20");

	        tree.delete(20);

	        tree.printTree(tree.getRoot(), 0);
	        
	        tree = new BinaryTree();
	        tree.createTree5();

	        System.out.println();
	        System.out.println("Delete Node with 2 Children : 30");

	        tree.delete(30);

	        tree.printTree(tree.getRoot(), 0);
	    }
	}
