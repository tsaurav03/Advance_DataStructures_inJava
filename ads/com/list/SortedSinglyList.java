package ads.com.list;

public class SortedSinglyList implements SortedList {
	class Node {
		int data;
		Node next;
		
		Node(int element) {
			data = element;
			next = null;
		}
	}
	
	Node head;

	public SortedSinglyList() {
		head = null;
	}

	@Override
	public void insert(int element) {
		Node newNode = new Node(element);
		
		if (isEmpty()) {
			head = newNode;
			return;
		}

		Node previous = null;
		Node current = head;
		while (current != null) {
			if (current.data > newNode.data) {
				break;
			}

			previous = current;
			current = current.next;
		}

		if (previous == null) {
			newNode.next = head;
			head = newNode;
			return;
		}
		
		previous.next = newNode;
		newNode.next = current;
	}

	@Override
	public void delete(int element) {
	}

	@Override
	public void print() {
		Node current = head;
		
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println("");
	}

	@Override
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}
}
