package q.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class InsertIntoACyclicSortedList extends Question {

	@Override
	public String getQuestion() {

		/**
		 * Given a node from a cyclic linked list which has been sorted, write a
		 * function to insert a value into the list such that it remains a
		 * cyclic sorted list. The given node can be any single node in the
		 * list.
		 */

		return "http://leetcode.com/2011/08/insert-into-a-cyclic-sorted-list.html";
	}

	@Test(dataProvider = "dataProvider")
	public void insert(Node node, Integer num) {

		Node head = node;
		Node current = node;
		Node newNode = new Node();
		newNode.value = num;

		Log("\nBefore:" + head);

		while (true) {

			Node next = current.next;

			if (next == head) {

				current.next = newNode;
				newNode.next = next;
				break;
			}

			if (current.value <= num && next.value >= num) {
				current.next = newNode;
				newNode.next = next;
				break;
			} else if (next.value < current.value) {

				if (current.value >= num && next.value >= num) {
					current.next = newNode;
					newNode.next = next;
					break;
				} else if (current.value <= num && next.value <= num) {
					current.next = newNode;
					newNode.next = next;
					break;
				}

			}
			
			current = current.next;
		}

		Log("After:" + head);

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
