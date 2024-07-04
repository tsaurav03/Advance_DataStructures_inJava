package ads.com.dp;

public class fibonacciOperations {

	public static void testnthTerm(int n) {
		System.out.println(n + "th term using DP iterative is "
				+ Fibonacci.nTermI_DP(n) + ", loopCount = "
				+ Fibonacci.loopCount);

		System.out.println(n + "th term using DP recursive is "
				+ Fibonacci.nTermR_DP(n) + ", loopCount = "
				+ Fibonacci.loopCount);

		System.out.println(n + "th term using non-DP recursive is "
			+ Fibonacci.nthTermR(n) + ", loopCount = "
			+ Fibonacci.loopCount);
	}
	public static void main(String[] args) {
		testnthTerm(10);
		testnthTerm(45);
	}

}
