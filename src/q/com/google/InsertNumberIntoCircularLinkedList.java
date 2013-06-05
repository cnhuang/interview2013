package q.com.google;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class InsertNumberIntoCircularLinkedList extends Question {

	@Override
	public String getQuestion() {
		return "Insert a number into a circular linkedlist";
	}

	@Test(dataProvider = "dataProvider")
	public void insert(Node node, int i) {

		// assume it is an increasing linkedlist

		Node first = node;
		Node current = node;
		
		Log("\n\nInsert:" + i);
		Log("LinkedList:" + node.toString());
		
		Node newNode = new Node();
		newNode.value = i;

		while (true) {

			Node next = current.next;

			Log("Current:" + current.value + ", Next:" + next.value);

			if (next == first) {
				Log("Can't find a spot. Insert between " + current.value
						+ " and " + next.value);
				current.next = newNode;
				newNode.next = next;
				break;
			} else if (current.value <= i && next.value >= i) {
				Log("Insert between " + current.value + " and " + next.value);
				current.next = newNode;
				newNode.next = next;
				break;
			} else if (current.value < i && next.value < i
					&& next.value < current.value) {
				Log("Insert in tail. between " + current.value + " and "
						+ next.value);
				current.next = newNode;
				newNode.next = next;
				break;
			} else if (current.value > i && next.value > i
					&& next.value < current.value) {
				Log("Insert in head. between " + current.value + " and "
						+ next.value);
				current.next = newNode;
				newNode.next = next;
				break;
			}

			// Important. there is alwyas a case that you can't make a decision
			// such as 4-4 insert 7

			Log("No decision yet");
			current = current.next;
		}
		Log("New LinkedList:" + node.toString());

	}

	@DataProvider
	public static Object[][] dataProvider() {

		return new Object[][] {
				{ Node.createLinkedList(new int[] { 4, 4 }), 2 },
				{ Node.createLinkedList(new int[] { 4, 4 }), 4 },
				{ Node.createLinkedList(new int[] { 4, 4 }), 5 },
				{ Node.createLinkedList(new int[] { 4, 4, 7 }), 2 },
				{ Node.createLinkedList(new int[] { 4, 4, 7 }), 4 },
				{ Node.createLinkedList(new int[] { 4, 4, 7 }), 5 },
				{ Node.createLinkedList(new int[] { 4, 4, 7 }), 7 },
				{ Node.createLinkedList(new int[] { 4, 4, 7 }), 8 },
				{ Node.createLinkedList(new int[] { 1, 4 }), 0 },
				{ Node.createLinkedList(new int[] { 1, 4 }), 1 },
				{ Node.createLinkedList(new int[] { 1, 4 }), 2 },
				{ Node.createLinkedList(new int[] { 1, 4 }), 4 },
				{ Node.createLinkedList(new int[] { 1, 4 }), 5 },
				{ Node.createLinkedList(new int[] { 1 }), 0 },
				{ Node.createLinkedList(new int[] { 1 }), 1 },
				{ Node.createLinkedList(new int[] { 1 }), 2 },
				{ Node.createLinkedList(new int[] { 4, 5, 6, 1, 2, 3, }), 0 },
				{ Node.createLinkedList(new int[] { 4, 5, 6, 1, 2, 3, }), 1 },
				{ Node.createLinkedList(new int[] { 4, 5, 6, 1, 2, 3, }), 2 },
				{ Node.createLinkedList(new int[] { 4, 5, 6, 1, 2, 3, }), 3 },
				{ Node.createLinkedList(new int[] { 4, 5, 6, 1, 2, 3, }), 4 },
				{ Node.createLinkedList(new int[] { 4, 5, 6, 1, 2, 3, }), 5 },
				{ Node.createLinkedList(new int[] { 4, 5, 6, 1, 2, 3, }), 6 },
				{ Node.createLinkedList(new int[] { 4, 5, 6, 1, 2, 3, }), 7 },
				{ Node.createLinkedList(new int[] { 4, 5, 6, 1, 2, 3, }), 8 } };
	}

	public static class Node {
		int value;
		Node next;

		public static Node createLinkedList(int[] arr) {

			Node root = new Node();
			root.value = arr[0];

			Node current = root;
			current.next = root;

			for (int i = 1; i < arr.length; i++) {

				Node node = new Node();
				node.value = arr[i];
				current.next = node;
				node.next = root;
				current = node;
			}

			return root;
		}

		public String toString() {

			Node node = this;
			String str = "";

			do {
				str += node.value + "=>";
				node = node.next;
			} while (node != this);

			return str;

		}

	}
}
