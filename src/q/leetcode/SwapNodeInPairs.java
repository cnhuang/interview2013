package q.leetcode;

import util.Question;

public class SwapNodeInPairs extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a linked list, swap every two adjacent nodes and return its
		 * head.
		 * 
		 * For example, Given 1->2->3->4, you should return the list as
		 * 2->1->4->3.
		 * 
		 * Your algorithm should use only constant space. You may not modify the
		 * values in the list, only nodes itself can be changed.
		 */
		return "http://leetcode.com/onlinejudge#question_24";
	}

	public ListNode swapPairs(ListNode head) {

		return swapPairs_recursive(head);

	}

	public ListNode swapPairs_recursive(ListNode node) {

		if (node == null)
			return null;

		if (node.next == null)
			return node;

		ListNode next = node.next;
		ListNode nexthead = swapPairs_recursive(next.next);

		next.next = node;
		node.next = nexthead;

		return next;
	}

	public ListNode swapPairs_iterative(ListNode node) {

		if (node == null)
			return null;

		ListNode newhead = null;
		ListNode pre = null;
		ListNode curr = node;

		while (curr != null) {

			ListNode next = curr.next;

			if (next != null) {

				ListNode tmp = next.next;

				next.next = curr;
				curr.next = null;

				if (pre != null)
					pre.next = next;

				if (newhead == null)
					newhead = next;

				pre = curr;
				curr = tmp;

			} else {
				if (pre != null)
					pre.next = curr;

				if (newhead == null)
					newhead = curr;

				curr = null;
			}
		}
		
		return newhead;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
