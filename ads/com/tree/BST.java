package ads.com.tree;

public class BST {
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

	public BST() {
		root = null;
	}
	
	private void printUsingInorder(Node root) {
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
		printUsingInorder(root);
		System.out.println("");
	}
	
	public boolean search(int element) {
		Node current = root;

		while (current != null) {
			if (current.data == element) {
				return true;
			}
			
			if (element < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		
		return false;
	}
	
	public void insert(int element) {
		Node newNode = new Node(element);
		
		if (root == null) {
			root = newNode;
			return;
		}

		Node current = root;

		while (current != null) {
			if (current.data == element) {
				// To not allow duplicate elements.
				return;
			}
			
			if (element < current.data) {
				if (current.left == null) {
					current.left = newNode;
					return;
				}
				current = current.left;
			} else {
				if (current.right == null) {
					current.right = newNode;
					return;
				}
				current = current.right;
			}
		}
	}
	
	public void delete(int element) {
		Node parent = null;
		Node current = root;

		while (current != null) {
			if (current.data == element) {
				break;
			}

			parent = current;
			if (element < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}

		if (current == null) {
			return;
		}

		// Deleting leaf node?
		if ((current.left == null) && (current.right == null)) {
			// Are we deleting root node?
			if (current == root) {
				root = null;
				return;
			}
			
			if (current == parent.left) {
				parent.left = null;
			} else {
				parent.right = null;
			}
			return;
		}

		// Which is the only child of current?
		Node childOfCurrent = null;
		if (current.left == null) {
			childOfCurrent = current.right;
		}
		if (current.right == null) {
			childOfCurrent = current.left;
		}
		
		if (childOfCurrent != null) {
			// current has only one child.
			if (current == parent.left) {
				parent.left = childOfCurrent;
			} else {
				parent.right = childOfCurrent;
			}
			return;
		}
		
		// Current has two child nodes.
		Node inorderSuccessorParent = null;
		Node inorderSuccessor = current.right;
		while (inorderSuccessor.left != null) {
			inorderSuccessorParent = inorderSuccessor;
			inorderSuccessor = inorderSuccessor.left;
		}
		
		int temp = inorderSuccessor.data;
		inorderSuccessor.data = current.data;
		current.data = temp;

		if (inorderSuccessor == inorderSuccessorParent.left) {
			inorderSuccessorParent.left = inorderSuccessor.right;
		} else {
			inorderSuccessorParent.right = inorderSuccessor.right;
		}
	}
}
