package q.com.amzn;

import java.util.Arrays;
import java.util.Random;

public class ConstantTimeStorage {

	// http://www.careercup.com/question?id=12650665
	// Given a set of unique numbers from 1 to 1000, propose a data structure
	// that
	// allows you to perform the following operations in constant time.
	// 1- Insertion,
	// 2- Deletion,
	// 3- Searching,
	// 4- Get any random number.

	public static class Storage {

		Node[] tailIndex = new Node[1000];
		Node[] data;
		int size = 0;

		Random rand = new Random(System.currentTimeMillis());

		public Storage(int max) {
			data = new Node[10000];
		}

		public void insert(int i) {

			Node n = new Node(i);

			if (tailIndex[i] == null) {
				tailIndex[i] = n;
			} else {
				n.parent = tailIndex[i];
				tailIndex[i].child = n;
				tailIndex[i] = n;
			}

			n.index = size;
			data[size++] = n;
		}

		public boolean delete(int i) {

			if (tailIndex[i] == null)
				return false;
			else {
				Node n = tailIndex[i];
				tailIndex[i] = n.parent;

				if (n.index != size - 1) {
					data[size - 1].index = n.index;
					data[n.index] = data[size - 1];
				}

				data[size - 1] = null;
				size--;
				return true;
			}

		}

		public boolean search(int i) {
			return tailIndex[i] != null;
		}

		public int random() {
			if (size == 0)
				return -1;
			return tailIndex[rand.nextInt(size)].value;
		}

		public String toString() {
			return "Size:" + size + ", " + Arrays.toString(data);
		}

	}

	public static class Node {

		public Node(int value) {
			this.value = value;
		}

		int index;
		int value;
		Node parent;
		Node child;

		public String toString() {
			return String.valueOf(value);
		}
	}

	public static void main(String[] args) {
		Storage test = new Storage(10);
		for (int i = 10; i > 0; i--) {
			test.insert(i);
			System.out.println(test);
		}

		System.out.println();

		for (int i = 1; i <= 10; i += 2) {
			test.delete(i);
			System.out.println(test);
			System.out.println(i + "=>" + test.search(i));
		}

		System.out.println();

		for (int i = 9; i >= 1; i -= 2) {
			test.insert(i);
			System.out.println(test);
			System.out.println(i + "=>" + test.search(i));
		}

		System.out.println();

		for (int i = 10; i > 0; i--) {
			System.out.println(test.random());
		}

	}

}
