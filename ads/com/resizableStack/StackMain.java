package ads.com.resizableStack;

public class StackMain<T> implements StackInterface<T>{
	private static final int DEFAULT_CAPACITY = 10;
	private T[] Arr;
	private int top;

	public StackMain() {
		Arr = (T[])new Object[DEFAULT_CAPACITY];
		top = -1;
	}

	public T[] resizeArray(T[] arr) {
		T[] newArray = (T[])new Object[(arr.length + 1)];
		for (int i = 0; i < arr.length; ++i) {
			newArray[i] = arr[i];
		}

		return newArray;
	}

	public static void main(String[] args) {
		StackMain<String> ob = new StackMain();
		ob.push("Seeta");
		ob.push("Geeta");
		ob.push("Neeta");
		System.out.println("Top elements are "+ob.peek());
		ob.printStack();
		ob.pop();
		ob.pop();
		System.out.println("After Pop");
		ob.printStack();
		
		StackMain<Integer> ob1 = new StackMain();
		ob1.push(100);
		ob1.push(200);
		ob1.push(3000);
		System.out.println("Top elements are "+ob.peek());
		ob1.printStack();
		ob1.pop();
		ob1.pop();
		System.out.println("After Pop");
		ob1.printStack();
		
		
	}


	public void push(T element) {
		if (isFull()) {
			Arr = resizeArray(Arr);
//			throw new StackOverflowException("Stack is full cannot be added");
		}

		++top;
		Arr[top] = element;
	}

	@Override
	public T pop() {
		if (isEmpty()) {
			throw new StackUnderflowException("Stack Is empty cannot remove");
		}
		T res = Arr[top];
		Arr[top]=null;
		--top;
		return res;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new StackOverflowException("Stack is Empty");
		}
		return Arr[top];
	}

	@Override
	public boolean isEmpty() {
		if (top == -1)
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if (top == (Arr.length - 1))
			return true;
		return false;
	}

	@Override
	public void printStack() {
		for(int i=0;i<Arr.length;i++)
		{
			System.out.print(i+"="+Arr[i]+"\n");
		}
	}

}
