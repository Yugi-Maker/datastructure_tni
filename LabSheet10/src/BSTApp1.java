
public class BSTApp1 {

	public static void main(String[] args) {
		
		BinarySearchTree tree = new BinarySearchTree();
		tree.sampleTree1();
		tree.printTree(tree.getRoot(), 0);
		
		System.out.println("\nMinimum Node is " + tree.findMinimum(tree.getRoot()).data);
		System.out.println("Maximum Node is " + tree.findMaximum(tree.getRoot()).data);
		
		int target = 40;

        System.out.println("Is " + target +" in BST => " + tree.findSpecificData(target));
		
		int delNode = 60;
		tree.searchDeleteNode(delNode);
		System.out.println("Parent = " + tree.getParent().data);
		System.out.println("Delete Node = " + tree.getDeleteNode().data);
		
		tree.delete(delNode);
		tree.printTree(tree.getRoot(), 0);

	}

}
