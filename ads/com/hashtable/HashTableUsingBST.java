package ads.com.hashtable;

import ads.com.tree.BST;

public class HashTableUsingBST implements HashTable {
	BST[] buckets;
	int hashTableSize;

	public HashTableUsingBST() {
		hashTableSize = 10;
		buckets = new BST[hashTableSize];
		for (int i = 0; i < hashTableSize; ++i) {
			buckets[i] = new BST();
		}
	}

	private int modN(int key) {
		return key % hashTableSize;
	}

	@Override
	public void insert(int key) {
		int bucketId = modN(key);

		buckets[bucketId].insert(key);
		System.out.println(key + " stored in bucket " + bucketId);
	}

	@Override
	public boolean search(int key) {
		int bucketId = modN(key);

		return buckets[bucketId].search(key);
	}

}
