package ads.com.list;

import java.util.Iterator;

public class iterableListOperations {

	public static void main(String[] args) {
		IterableList list = new CircularDoublyList();
		
		list.insert(10);
		list.insert(1);
		list.insert(40);
		list.insert(20);
		list.insert(15);
		list.insert(5);
		
		for (int value : list) {
			System.out.print(value + " ");
		}
		System.out.println("");
		
		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println("\n");
	}

}
