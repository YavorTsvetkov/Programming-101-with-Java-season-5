package week6.map.hashMap;

import week6.map.bucket.*;

public class MyHashMap<K, V> implements MapInterface<K, V> {
	
	private BucketInterface<K, V>[] buckets;
	private double loadFactor;
	private int size;
	
	public MyHashMap() {
		this.size = 16;
		this.loadFactor = 0.75;
		
		this.buckets = new LinkedBucket[this.size];
		
		for (BucketInterface<K, V> bucket : buckets) {
			bucket = new LinkedBucket<K, V>();
		}
	}
	
	public MyHashMap(int size, double loadFactor) {
		this.size = size;
		this.loadFactor = loadFactor;
		
		this.buckets = new LinkedBucket[this.size];
		
		for (BucketInterface<K, V> bucket : buckets) {
			bucket = new LinkedBucket<K, V>();
		}
	}
	
	private int calcIndex(K key) {
		return key.hashCode() % this.size;
	}

	public void put(K key, V value) {
		int index = calcIndex(key);
		this.buckets[index].add(key, value);
		
	}

	public V get(K key) {
		int index = calcIndex(key);
		return this.buckets[index].get(key);
	}

	public void remove(K key) {
		int index = calcIndex(key);
		this.buckets[index].remove(key);
	}

	public boolean containsKey(K key) {
		return (get(key) != null);
	}

}
