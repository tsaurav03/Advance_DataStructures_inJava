package ads.com.list;

public class SinglyListUsingNodePool implements List {
	class Node {
		int data;
		Node next;
	}

	class NodePoolManager {
		Node [] nodesPool;
		boolean[] isNodeFree;
		
		public NodePoolManager(int poolSize) {
			nodesPool = new Node[poolSize];
			isNodeFree = new boolean[poolSize];

			for (int i = 0; i < poolSize; ++i) {
				nodesPool[i] = new Node();
				isNodeFree[i] = true;
			}
		}
		
		public Node createNode() {
			for (int i = 0; i < isNodeFree.length; ++i) {
				if (isNodeFree[i]) {
					isNodeFree[i] = false;
					return nodesPool[i];
				}
			}
			return null;
		}
		
		public void deleteNode(Node node) {
			for (int i = 0; i < nodesPool.length; ++i) {
				if (nodesPool[i] == node) {
					isNodeFree[i] = true;
					break;
				}
			}
		}
	}
	
	Node head;
	Node tail;
	
	NodePoolManager nodePool;

	public SinglyListUsingNodePool() {
		head = null;
		tail = null;
		
		nodePool = new NodePoolManager(10);
	}

	@Override
	public void addAtFront(int element) {
		Node newNode = nodePool.createNode(); //new Node();
		newNode.data = element;
		newNode.next = head;
		head = newNode;
		
		if (tail == null) {
			tail = newNode;
		}
	}

	@Override
	public void addAtRear(int element) {
		Node newNode = nodePool.createNode(); //new Node();
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
		
		int value = temp.data;
		nodePool.deleteNode(temp);
		return value; //temp.data;
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
