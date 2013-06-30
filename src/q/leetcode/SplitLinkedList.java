package q.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ds.Node;
import ds.TreeNode;

import util.Question;

public class SplitLinkedList extends Question {

	@Override
	public String getQuestion() {
		return "http://leetcode.com/2010/09/splitting-linked-list.html";
	}

	@Test(dataProvider = "dataProvider")
	public void split(Node<Integer> n) {

		Log("Input:" + n);

		Node<Integer> head1 = n;
		Node<Integer> head2 = null;

		if (head1 != null) {

			Node<Integer> index1 = head1;
			Node<Integer> index2 = head1.next;

			if (index2 != null) {

				while (true) {

					if (index2.next == null) {
						head2 = index1.next;
						index1.next = null;
						break;
					} else {
						index1 = index1.next;
						index2 = index2.next;
					}

					if (index2.next == null) {
						head2 = index1.next;
						index1.next = null;
						break;
					} else
						index2 = index2.next;
				}
			}
		}

		Log("head1:" + head1);
		Log("head2:" + head2);

	}

	@DataProvider
	public static Object[][] dataProvider() {

		return new Object[][] {

		{ null },

		{ Node.Create(new Integer[] { 1 }) },

		{ Node.Create(new Integer[] { 1, 2 }) },

		{ Node.Create(new Integer[] { 1, 2, 3 }) },

		{ Node.Create(new Integer[] { 1, 2, 3, 4 }) },

		{ Node.Create(new Integer[] { 1, 2, 3, 4, 5 }) },

		{ Node.Create(new Integer[] { 1, 2, 3, 4, 5, 6 }) },

		};
	}
}
