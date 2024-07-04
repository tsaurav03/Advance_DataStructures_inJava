package ads.com.stack;

public class FixedSizeStack implements Stack {
	private int[] stackData;
	private int top;

	public FixedSizeStack(int n) {
		stackData = new int[n];
		top = -1;
	}

	@Override
	public void push(int element) {
		if (isFull()) {
			throw new StackOverflowException("Stack is full. Failed to push element.");
		}

		++top;
		stackData[top] = element;
	}

	@Override
	public int pop() {
		if (isEmpty()) {
			throw new StackUnderflowException("Stack is empty. Failed to pop element.");
		}

		int result = stackData[top];
		--top;

		return result;
	}


	@Override
	public int peek() {
		if (isEmpty()) {
			throw new StackUnderflowException("Stack is empty.");
		}

		return stackData[top];
	}

	@Override
	public boolean isEmpty() {
		if (top == -1)
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if (top == (stackData.length - 1))
			return true;
		return false;
	}
}
