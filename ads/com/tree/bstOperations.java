package ads.com.tree;

public class bstOperations {
	public static void main(String[] args) {
		BST bst01 = new BST();
		
		bst01.insert(10);
		bst01.insert(5);
		bst01.insert(8);
		bst01.insert(20);
		bst01.insert(15);
		bst01.insert(1);
		bst01.insert(40);
		bst01.insert(50);	
		bst01.printUsingInorder();

		bst01.delete(10);
		bst01.delete(1);
		bst01.delete(40);
		bst01.printUsingInorder();
	}
}
