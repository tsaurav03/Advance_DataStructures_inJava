package ads.com.dp;

public class Fibonacci {
	public static int loopCount;

	private static int nthTermR_(int n) {
		++loopCount;
		if ((n == 1) || (n == 2)) {
			return 1;
		}
		
		return nthTermR_(n - 1) + nthTermR_(n - 2);
	}
	public static int nthTermR(int n) {
		loopCount = 0;
		return nthTermR_(n);
	}
	
	private static int nTermR_DP(int n, int[] table) {
		++loopCount;
		
		if (table[n] != 0) {
			return table[n];
		}
		
		if (table[n - 1] == 0) {
			table[n - 1] = nTermR_DP(n - 1, table);
		}
		if (table[n - 2] == 0) {
			table[n - 2] = nTermR_DP(n - 2, table);
		}
		return table[n - 1] + table[n - 2];
	}
	public static int nTermR_DP(int n) {
		int[] table = new int[n + 2];
		for (int i = 0; i < table.length; ++i) {
			table[i] = 0;
		}
		
		loopCount = 0;
		
		table[1] = 1;
		table[2] = 1;
		table[n] = nTermR_DP(n, table);
		return table[n];
	}
	
	public static int nTermI_DP(int n) {
		int[] table = new int[n + 2];
		for (int i = 0; i < table.length; ++i) {
			table[i] = 0;
		}
		
		loopCount = 0;
		
		table[1] = 1;
		table[2] = 1;
		
		for (int i = 3; i <= n; ++i) {
			++loopCount;
			table[i] = table[i - 1] + table[i - 2];
		}

		return table[n];
	}
}
