package ads.com.stack;
import java.util.Arrays;

public class stackOperations {
	public static void reverseArray(int[] arr, Stack stack) {
		for (int i = 0; i < arr.length; ++i) {
			stack.push(arr[i]);
		}

		int i = 0;
		while (!stack.isEmpty()) {
			arr[i] = stack.pop();
			++i;
		}
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		Stack stackObj = new FixedSizeStack(10);

		System.out.println("Before reversing: " + Arrays.toString(arr));
		reverseArray(arr, stackObj);
		System.out.println("After reversing : " + Arrays.toString(arr));
	}
}
