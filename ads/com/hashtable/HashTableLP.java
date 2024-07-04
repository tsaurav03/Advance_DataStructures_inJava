package ads.com.hashtable;

public class HashTableLP implements HashTable {
	Integer[] buckets;
	int hashTableSize;
	double loadFactor;
	int keyCount;

	public HashTableLP() {
		hashTableSize = 10;
		loadFactor = 0.75;
		keyCount = 0;
		
		buckets = new Integer [hashTableSize];
	}

	private int modN(int key) {
		return key % hashTableSize;
	}

	private void resizeHashTable() {
		Integer[] oldBuckets = buckets;
		
		hashTableSize *= 2;
		System.out.println("Hash table resized to " + hashTableSize);
		buckets = new Integer[hashTableSize];
		
		keyCount = 0;

		System.out.println("\nRehashing started.");
		for (int i = 0; i < oldBuckets.length; ++i) {
			if (oldBuckets[i] != null) {
				insert(oldBuckets[i]);
			}
		}
		System.out.println("Rehashing ends.\n");
	}

	@Override
	public void insert(int key) {
		if (keyCount >= (loadFactor * hashTableSize)) {
			resizeHashTable();
		}

		int bucketId = modN(key);
		
		if (buckets[bucketId] == null) {
			buckets[bucketId] = key;
			System.out.println(key + " stored in bucket " + bucketId);
			++keyCount;
			return;
		}
		
		// Do Linear Probing.
		int i = 1;
		int lpCount = 1;
		while (lpCount < hashTableSize) {
			int id = (bucketId + i) % hashTableSize;
			
			if (buckets[id] == null) {
				buckets[id] = key;
				System.out.println(key + " stored in bucket " + id + " after LP for " + lpCount + " times.");
				++keyCount;
				return;
			}
			
			++i;
			++lpCount;
		}
		
		resizeHashTable();
		insert(key);
	}

	@Override
	public boolean search(int key) {
		int bucketId = modN(key);
		
		if (buckets[bucketId] == null) {
			return false;
		}

		if (buckets[bucketId] == key) {
			return true;
		}

		// Do Linear Probing.
		int i = 1;
		int lpCount = 1;
		while (lpCount < hashTableSize) {
			int id = (bucketId + i) % hashTableSize;
			
			if (buckets[id] == null) {
				return false;
			}
			
			if (buckets[id] == key) {
				return true;
			}
			
			++i;
			++lpCount;
		}

		return false;
	}

}
