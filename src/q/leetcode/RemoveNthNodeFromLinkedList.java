package q.leetcode;

import util.Question;

public class RemoveNthNodeFromLinkedList extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a linked list, remove the nth node from the end of list and
		 * return its head.
		 * 
		 * For example,
		 * 
		 * Given linked list: 1->2->3->4->5, and n = 2.
		 * 
		 * After removing the second node from the end, the linked list becomes
		 * 1->2->3->5. Note: Given n will always be valid. Try to do this in one
		 * pass.
		 */
		return "http://leetcode.com/onlinejudge#question_19";
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {

		if (n < 1)
			return head;

		ListNode current = head;
		ListNode end = head;

		for (int i = 0; i < n; i++) {
			//means n > head.length
			if (end == null)
				return head;
			end = end.next;
		}

		//remove head
		if (end == null)
			return head.next;

		while (end.next != null) {
			current = current.next;
			end = end.next;
		}

		current.next = current.next.next;

		return head;

	}

}
