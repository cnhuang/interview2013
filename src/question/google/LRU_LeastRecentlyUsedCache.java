package question.google;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.testng.annotations.Test;

import util.Question;

public class LRU_LeastRecentlyUsedCache extends Question {

	@Override
	public String getQuestion() {
		return "Implement a LRU cache.(Hint: Use linkedlist + Hashtable)";
	}

	@Test
	public void testCache() {

		Random rand = new Random(System.currentTimeMillis());
		LRUCache<String, Integer> cache = new LRUCache<String, Integer>();

		for (int i = 0; i < 20; i++) {
			String key = "Key " + rand.nextInt(20);
			Integer value = rand.nextInt(100);
			Log("\nGet Key:" + key + ", Value:" + value);

			if (cache.get(key) == null) {
				Log("Key:" + key + ", does not exist.");
			}

			cache.put(key, value);

			Log("Cache:" + cache.toString());

		}

	}

	public static class LRUCache<K, V> {

		int size = 5;
		int currentSize = 0;
		Map<Object, LRUNode<K, V>> map = new HashMap<Object, LRUNode<K, V>>();
		LRUNode<K, V> head = null;
		LRUNode<K, V> tail = null;

		public V get(K key) {

			LRUNode<K, V> node = null;

			if (map.containsKey(key)) {
				node = map.get(key);

				detach(node);
				attach(node);

				return node.data;
			}

			return null;
		}

		private void detach(LRUNode<K, V> node) {

			if (node == null)
				return;

			if (node.prev != null) {
				node.prev.next = node.next;
			} else {
				head = node.next;
			}

			if (node.next != null)
				node.next.prev = node.prev;
			else
				tail = node.prev;

			node.prev = null;
			node.next = null;
		
			currentSize--;
			map.remove(node.key);
		}

		private void attach(LRUNode<K, V> node) {

			if (node == null)
				return;

			if (head == null) {
				head = node;
				tail = node;
			} else {
				node.next = head;
				head.prev = node;
				head = node;
			}

			map.put(node.key, node);

			currentSize++;
			if (currentSize > size) {
				detach(tail);
			}
		}

		public void put(K key, V value) {

			if (map.containsKey(key)) {
				get(key);
				map.get(key).data = value;
			} else {
				LRUNode<K, V> node = new LRUNode<K, V>();
				node.key = key;
				node.data = value;
				attach(node);
			}
		}

		public String toString() {
			if (head == null)
				return null;
			return head.toString();
		}

	}

	public static class LRUNode<K, V> {
		V data;
		K key;
		LRUNode<K, V> next;
		LRUNode<K, V> prev;

		public String toString() {
			return "(" + key + "," + data + ")"
					+ ((next != null) ? "->" + next.toString() : "");
		}
	}

}
