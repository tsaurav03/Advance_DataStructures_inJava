package ads.com.resizableStack;

public interface StackInterface<T> {

	 void push(T element);
	 T pop();
	 T peek();
	 boolean isEmpty();
	 boolean isFull();
	 void printStack();

}
