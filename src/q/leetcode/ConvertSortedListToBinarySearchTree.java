package q.leetcode;

import util.Question;

public class ConvertSortedListToBinarySearchTree extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a singly linked list where elements are sorted in ascending
		 * order, convert it to a height balanced BST.
		 */
		return "http://leetcode.com/onlinejudge#question_109";
	}

	public TreeNode sortedListToBST(ListNode head) {

		if (head == null)
			return null;

		return sortedListToBST(new Wrapper(head), 0, getLength(head) - 1);

	}

	public int getLength(ListNode head) {

		int i = 0;

		while (head != null) {
			i++;
			head = head.next;
		}

		return i;
	}

	public class Wrapper {

		ListNode n;

		public Wrapper(ListNode node) {
			n = node;
		}
	}

	public TreeNode sortedListToBST(Wrapper head, int s, int e) {

		if (s > e)
			return null;

		int mid = (s + e) / 2;

		TreeNode left = sortedListToBST(head, s, mid - 1);
		TreeNode n = new TreeNode(head.n.val);
		head.n = head.n.next;
		TreeNode right = sortedListToBST(head, mid + 1, e);

		n.left = left;
		n.right = right;

		return n;

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
