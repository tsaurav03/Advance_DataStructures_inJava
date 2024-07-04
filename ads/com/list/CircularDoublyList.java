package ads.com.list;

import java.util.Iterator;



public class CircularDoublyList implements IterableList {
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

	private Node createDummyNode() {
		Node dummyNode = new Node(0);
		
		dummyNode.next = dummyNode;
		dummyNode.previous = dummyNode;
		
		return dummyNode;
	}
	public CircularDoublyList() {
		head = createDummyNode();
	}

	@Override
	public void insert(int element) {
		Node newNode = new Node(element);
		
		Node current = head.next;
		while (current != head) {
			if (current.data > element) {
				break;
			}
			
			current = current.next;
		}

		newNode.next = current;
		newNode.previous = current.previous;
		current.previous.next = newNode;
		current.previous = newNode;
	}

	@Override
	public void delete(int element) {
	}

	@Override
	public boolean isEmpty() {
		if (head.next == head) {
			return true;
		}
		return false;
	}

	class ForwardIterator implements Iterator<Integer> {
		Node current = head.next;

		@Override
		public boolean hasNext() {
			if (current == head) {
				return false;
			}
			return true;
		}

		@Override
		public Integer next() {
			int value = current.data;
			current = current.next;
			return value;
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return new ForwardIterator();
	}

}
