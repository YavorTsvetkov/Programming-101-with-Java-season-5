package week6.map.bucket;

import java.util.LinkedList;

public class LinkedBucket<K, V> implements BucketInterface<K, V> {
	
	private class Entry {
		private K key;
		private V value;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return this.key;
		}
		
		public V getValue() {
			return this.value;
		}
		
		public void setValue(V value) {
			this.value = value;
		}
	}

	private LinkedList<Entry> list;
	
	public LinkedBucket() {
		this.list = new LinkedList<Entry>();
	}
	
	private Entry getEntry(K key) {
		for (Entry entry : list) {
			if (entry.getKey().equals(key)) {
				return entry;
			}
		}
		
		return null;
	}
	
	public void add(K key, V value) {
		Entry entry = new Entry(key, value);
		
		//if list doesn' t contain key
		if (getEntry(key) == null) {
			list.add(entry);
			return;
		}
		
		//if list contains key
		getEntry(key).setValue(value);
		
	}

	public void remove(K key) {
		list.remove(getEntry(key));
	}

	public V get(K key) {
		Entry entry = getEntry(key);
		
		if (entry == null) {
			return null;
		}
		
		return entry.getValue();
	}

}
