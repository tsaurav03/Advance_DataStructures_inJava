package ads.com.resizableQueue;

public interface Queue<T> {
	void enqueue(T element);

	T dequeue();

	T peek();

	boolean isEmpty();

	boolean isFull();

	void printQueue();
}
