package ads.com.queue;

public interface Queue {
	void enqueue(String element);
	String dequeue();
	boolean isEmpty();
	boolean isFull();
}
