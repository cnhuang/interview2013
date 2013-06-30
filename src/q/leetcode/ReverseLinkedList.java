package q.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ds.Node;

import util.Question;

public class ReverseLinkedList extends Question {

	@Override
	public String getQuestion() {
		/**
		 * Implement the reversal of a singly linked list iteratively and
		 * recursively.
		 */
		return "http://leetcode.com/2010/04/reversing-linked-list-iteratively-and.html";
	}

	@Test(dataProvider = "dataProvider")
	public void reverse_iterative(Node<Integer> head) {

		Log("Input:" + head);
		Node<Integer> prev = null;
		Node<Integer> curr = head;

		while (curr != null) {
			Node<Integer> next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		Log("Iterative:" + prev);
	}

	@Test(dataProvider = "dataProvider")
	public void reverse_recursive(Node<Integer> head) {

		Log("Input:" + head);
		Log("Recursive:" + reverse_recursive(null, head));
	}

	public Node<Integer> reverse_recursive(Node<Integer> p, Node<Integer> n) {

		if (n == null)
			return null;

		Node<Integer> head = reverse_recursive(n, n.next);
		n.next = p;
			
		if (head == null) {
			head = n;
		}

		return head;
	}

	@DataProvider
	public static Object[][] dataProvider() {

		Node<Integer> head = new Node<Integer>(0);
		Node<Integer> curr = head;

		for (int i = 1; i < 10; i++) {
			Node<Integer> n = new Node<Integer>(i);
			curr.next = n;
			curr = n;
		}

		return new Object[][] { { head } };
	}
}
