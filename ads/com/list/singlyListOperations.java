package ads.com.list;

public class singlyListOperations {

	public static void main(String[] args) {
		List list = new SinglyList();
		
		list.addAtFront(5);
		list.addAtFront(10);
		list.addAtFront(15);
		list.addAtRear(20);
		
		list.print();
	}

}
