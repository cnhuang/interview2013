package q.leetcode;

import util.Question;

public class RemoveDuplicatesfromSortedListII extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a sorted linked list, delete all nodes that have duplicate
		 * numbers, leaving only distinct numbers from the original list.
		 * 
		 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given
		 * 1->1->1->2->3, return 2->3.
		 */
		return "http://leetcode.com/onlinejudge#question_82";
	}

	public ListNode deleteDuplicates(ListNode head) {

		if (head == null)
			return head;

		ListNode curr = head;

		Integer current = null;
		head = null;
		ListNode tail = null;

		while (curr != null) {

			if ((current == null || curr.val != current)
					&& (curr.next == null || curr.next.val != curr.val)) {
				if (head == null) {
					head = curr;
					tail = curr;
				} else {
					tail.next = curr;
					// important
					tail = tail.next;
				}
			}

			current = curr.val;
			curr = curr.next;
		}

		// important
		if (tail != null)
			tail.next = null;
		else if (head != null)
			head.next = null;

		return head;

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
