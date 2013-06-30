package q.leetcode;

import util.Question;

public class ReverseNodeInGroupOfK extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a linked list, reverse the nodes of a linked list k at a time
		 * and return its modified list.
		 * 
		 * If the number of nodes is not a multiple of k then left-out nodes in
		 * the end should remain as it is.
		 * 
		 * You may not alter the values in the nodes, only nodes itself may be
		 * changed.
		 * 
		 * Only constant memory is allowed.
		 * 
		 * For example, Given this linked list: 1->2->3->4->5
		 * 
		 * For k = 2, you should return: 2->1->4->3->5
		 * 
		 * For k = 3, you should return: 3->2->1->4->5
		 */
		return "http://leetcode.com/onlinejudge#question_25";
	}

	public ListNode reverseKGroup(ListNode head, int k) {

		if (k <= 1)
			return head;

		return reverseKGroup_recursive(head, k);

	}

	public ListNode reverseKGroup_recursive(ListNode node, int k) {

		if (node == null)
			return null;

		ListNode tail = node;

		for (int i = 0; i < k - 1; i++) {

			tail = tail.next;

			if (tail == null)
				return node;
		}

		ListNode nextHead = reverseKGroup_recursive(tail.next, k);

		ListNode curr = node;
		ListNode pre = null;

		while (curr != tail) {

			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}

		curr.next = pre;
		node.next = nextHead;
		return curr;
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
