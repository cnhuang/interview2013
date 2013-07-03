package q.leetcode;

import util.Question;

public class RemoveDuplicatesfromSortedList extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a sorted linked list, delete all duplicates such that each
		 * element appear only once.
		 * 
		 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return
		 * 1->2->3.
		 */
		return "http://leetcode.com/onlinejudge#question_83";
	}

	public ListNode deleteDuplicates(ListNode head) {

		if (head == null)
			return head;

		ListNode curr = head;
		while (curr.next != null) {
			
			if(curr.next.val == curr.val)
				curr.next = curr.next.next;
			else{
				curr = curr.next;
			}			
		}
		
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
