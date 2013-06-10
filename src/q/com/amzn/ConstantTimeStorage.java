package q.com.amzn;

import java.util.LinkedList;
import java.util.List;
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
		List<Node> data = new LinkedList<Node>();
		int size = 0;

		public void insert(int i) {
			
			Node n = new Node();
			n.value = i;
			
			if (tailIndex[i] == null) {
				tailIndex[i] = n;
			}else{
				n.parent = tailIndex[i];
				tailIndex[i].child = n;
				tailIndex[i] = n;
			}
		}

		public void delete(int i) {

		}

		public boolean search(int i) {

		}

		public int random() {

		}

		public static class Node {
			int value;
			Node parent;
			Node child;
		}

	}

	public static void main(String[] args) {
		ConstantTimeStorage test = new ConstantTimeStorage(10);
		for (int i = 10; i > 0; i--) {
			test.Insert(i);
			System.out.println(test);
		}

		System.out.println();

		for (int i = 1; i <= 10; i += 2) {
			test.Delete(i);
			System.out.println(test);
			System.out.println(i + "=>" + test.Search(i));
		}

		System.out.println();

		for (int i = 9; i >= 1; i -= 2) {
			test.Insert(i);
			System.out.println(test);
			System.out.println(i + "=>" + test.Search(i));
		}

		System.out.println();

		for (int i = 10; i > 0; i--) {
			System.out.println(test.Random());
		}

	}

	int[] index;
	int[] data;
	int count;

	public ConstantTimeStorage(int size) {
		index = new int[size];
		data = new int[size];
		count = 0;

		for (int i = 0; i < size; i++) {
			index[i] = -1;
			data[i] = -1;
		}
	}

	static Random rand = new Random(System.currentTimeMillis());

	public int Random() {
		return data[rand.nextInt(count)];
	}

	public int Search(int n) {
		if (n < 1 || n > index.length)
			return -1;

		if (index[n - 1] == -1)
			return -1;
		else
			return data[index[n - 1]];
	}

	public void Insert(int n) {
		if (n < 1 || n > index.length)
			return;

		if (index[n - 1] == -1) {
			data[count] = n;
			index[n - 1] = count;
			count++;
		}
	}

	public void Delete(int n) {
		if (n < 1 || n > index.length)
			return;

		if (index[n - 1] != -1) {
			int i = index[n - 1];
			index[n - 1] = -1;

			count--;
			if (count > 0 && i != count) {
				int d = data[count];
				index[d - 1] = i;
				data[i] = d;
				data[count] = -1;
			}
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Count ").append(count).append(", Index:");
		for (int i = 0; i < index.length; i++)
			sb.append(index[i]).append(",");

		sb.append(", Data:");
		for (int i = 0; i < data.length; i++)
			sb.append(data[i]).append(",");
		return sb.toString();
	}

}
