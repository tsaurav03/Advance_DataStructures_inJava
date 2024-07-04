package ads.com.list;

public class sortedListOperations {

	public static void main(String[] args) {
		//SortedList list = new SortedSinglyList();
		SortedList list = new SortedDoublyList();
		
		list.insert(10);
		list.insert(20);
		list.insert(5);
		list.insert(15);
		
		list.print();
	}

}
