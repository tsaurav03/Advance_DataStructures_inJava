package ads.com.hashtable;

public class hashTableOperations {

	public static void test01(HashTable ht) {
		int[] keysToInsert = {23, 43, 12, 50, 95, 83, 77, 66, 53};
		for (int key : keysToInsert) {
			ht.insert(key);
		}

		int[] keysToSearch = {43, 72, 88, 77, 99};
		for (int key : keysToSearch) {
			if (ht.search(key)) {
				System.out.println(key + " found.");
			} else {
				System.out.println(key + " NOT found.");
			}
		}
	}

	public static void main(String[] args) {
		//test01(new HashTableLP());
		test01(new HashTableUsingBST());
	}

}
