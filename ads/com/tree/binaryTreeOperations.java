package ads.com.tree;

public class binaryTreeOperations {

	public static void main(String[] args) {
		BinaryTree bt01 = new BinaryTree();
		
		bt01.buildTree01();
		System.out.println("Inorder traversal is ...");
		bt01.printUsingInorder();
		System.out.println("Function call count is " + bt01.callCount);
	}

}
