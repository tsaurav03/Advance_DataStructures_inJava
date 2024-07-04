package ads.com.list;

public class SortedDoublyList implements SortedList {
	class Node {
		int data;
		Node next;
		Node previous;
		
		Node(int element) {
			data = element;
			next = null;
			previous = null;
		}
	}
	
	Node head;
	Node tail;

	public SortedDoublyList() {
		head = null;
		tail = null;
	}

	@Override
	public void insert(int element) {
		Node newNode = new Node(element);
		
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
			return;
		}

		Node current = head;
		while (current != null) {
			if (current.data > element) {
				break;
			}
			
			current = current.next;
		}

		if (current == head) {
			head.previous = newNode;
			newNode.next = head;
			head = newNode;
			return;
		}
		
		if (current == null) {
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
			return;
		}
		
		newNode.next = current;
		newNode.previous = current.previous;
		current.previous.next = newNode;
		current.previous = newNode;
	}

	@Override
	public void delete(int element) {
		// TODO Auto-generated method stub

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
