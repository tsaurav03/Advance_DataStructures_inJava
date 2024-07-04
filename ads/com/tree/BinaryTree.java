package ads.com.tree;

public class BinaryTree {
	class Node {
		int data;
		Node left;
		Node right;
		
		Node(int element) {
			data = element;
			left = null;
			right = null;
		}
	}
	
	private Node root;
	
	public int callCount;
	
	public BinaryTree() {
		root = null;
	}
	
	public void buildTree01() {
		Node n1 = new Node(5);
		Node n2 = new Node(10);
		Node n3 = new Node(4);
		Node n4 = new Node(3);
		
		n1.left = n2;
		n1.right = n3;
		
		n2.left = n4;
		
		root = n1;
	}

	private void printUsingInorder(Node root) {
		++callCount;
		if (root == null) {
			return;
		}
		
		if (root.left != null)
			printUsingInorder(root.left);

		System.out.print(root.data + " ");

		if (root.right != null)
			printUsingInorder(root.right);
	}
	public void printUsingInorder() {
		callCount = 0;
		printUsingInorder(root);
		System.out.println("");
	}
}
