package ads.com.queue;

public class queueOperations {
	public static void main(String[] args) {
		Queue queue = new QueueOfStrings(args.length);

		for (String arg : args) {
			queue.enqueue(arg);
		}

		while (!queue.isEmpty()) {
			System.out.print(queue.dequeue() + " ");
		}
		System.out.println("");

		for (String arg : args) {
			queue.enqueue(arg);
		}
	}

}
