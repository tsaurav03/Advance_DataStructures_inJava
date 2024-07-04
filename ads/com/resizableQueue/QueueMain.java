package ads.com.resizableQueue;

public class QueueMain<T> implements Queue<T> {
	private static final int DEFAULT_CAPACITY = 5;
	private T[] queueArr;
	private int front;
	private int rear;

	public QueueMain() {
		queueArr = (T[])new Object[DEFAULT_CAPACITY];
		rear=-1;
		front=-1;
		
	}
	public T[] resizeArray(T[] arr) {
		T[] newArray = (T[])new Object[(arr.length + 1)];
		for (int i = 0; i < arr.length; ++i) {
			newArray[i] = arr[i];
		}
		return newArray;
	}

	public static void main(String[] args) {
		QueueMain<Integer> ob=new QueueMain<>();
		ob.enqueue(10);
		ob.enqueue(20);
		ob.enqueue(30);
		ob.enqueue(40);
		ob.enqueue(50);
		ob.enqueue(60);
		ob.enqueue(40);
		ob.enqueue(50);
		ob.enqueue(60);
		ob.printQueue();
		System.out.println("\n==================================================\n");
		
		QueueMain<String> ob1=new QueueMain<>();
		ob1.enqueue("ABC");
		ob1.enqueue("ABC");
		ob1.enqueue("ABC");
		ob1.enqueue("ABC");
		ob1.enqueue("ABC");
		ob1.enqueue("ABC");
		ob1.printQueue();
		

	}

	@Override
	public void enqueue(T element) {
		if (isFull()) {
			queueArr = resizeArray(queueArr);
			//throw new QueueOverflowException("Queue is full cannot be Add");
		}
		++rear;
		queueArr[rear]=element;

	}

	@Override
	public T dequeue() {
		if(isEmpty()) {
			throw new QueueUnderflowException("Queue is Empty cannot remove");			
		}
		++front;
		T res=queueArr[front];
		queueArr[front]=null;
		return res;
	}

	@Override
	public T peek() {
		if(isEmpty()) {
			throw new QueueUnderflowException("Queue is Empty cannot Peek");
		}
		
		return queueArr[front];
	}

	@Override
	public boolean isEmpty() {
		if (front == rear) {
			return true;
		}
		return false;

	}

	@Override
	public boolean isFull() {
		if (rear == (queueArr.length - 1)) {
			return true;
		}
		return false;
	}

	@Override
	public void printQueue() {
		for(int i=0;i<queueArr.length;i++) {
			System.out.println(i+" = "+queueArr[i]);
		}

	}

}
