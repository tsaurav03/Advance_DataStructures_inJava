package ads.com.list;

public class SinglyList implements List {
	class Node {
		int data;
		Node next;
	}
	
	Node head;
	Node tail;
	
	public SinglyList() {
		head = null;
		tail = null;
	}

	@Override
	public void addAtFront(int element) {
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = head;
		head = newNode;
		
		if (tail == null) {
			tail = newNode;
		}
	}

	@Override
	public void addAtRear(int element) {
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = null;
		
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
			return;
		}
		
		tail.next = newNode;
		tail = newNode;
	}

	@Override
	public int deleteFirstNode() {
		if (head == null) {
			throw new NoDataException("List is empty. Nothing to delete.");
		}

		Node temp = head;
		head = head.next;
		
		if (isEmpty()) {
			tail = null;
		}
		
		return temp.data;
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
