package q.leetcode;

import org.testng.annotations.Test;

import util.Question;

public class ReverseLinkedListII extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Reverse a linked list from position m to n. Do it in-place and in
		 * one-pass.
		 * 
		 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
		 * 
		 * return 1->4->3->2->5->NULL.
		 * 
		 * Note: Given m, n satisfy the following condition: 1 ? m ? n ? length
		 * of list.
		 */
		return "http://leetcode.com/onlinejudge#question_92";
	}

	@Test
	public void test() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);

		n1.next = n2;
		n2.next = n3;

		Log(reverseBetween(n1, 3, 3).val);
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {

		if (n == 1)
			return head;

		ListNode current = head;

		for (int i = 1; i < m - 1; i++) {
			current = current.next;
		}

		ListNode beforeReverse = null;
		if (m > 1) {
			beforeReverse = current;
		}

		ListNode prev = beforeReverse;
		current = current.next;
		ListNode tail = current;

		int count = 1;

		while (count < n) {

			if (current == null)
				return head;

			ListNode next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		tail.next = current;

		if (beforeReverse == null)
			return prev;
		else {
			beforeReverse.next = prev;
			return head;
		}

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
