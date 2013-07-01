package q.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import util.Question;

public class MergeKLinkedList extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Merge k sorted linked lists and return it as one sorted list. Analyze
		 * and describe its complexity.
		 */
		return "http://leetcode.com/onlinejudge#question_23";
	}

	public ListNode mergeKLists(ArrayList<ListNode> lists) {

		if (lists == null || lists.size() == 0)
			return null;

		if (lists.size() == 1) {
			return lists.get(0);
		}

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(),
				new LNComparator());

		for (ListNode n : lists) {
			queue.add(n);
		}

		ListNode head = null;
		ListNode curr = null;

		while (!queue.isEmpty()) {

			ListNode n = queue.poll();

			if (head == null) {
				head = n;
				curr = n;
			} else {
				curr.next = n;
				curr = n;
			}

			if (n.next != null) {
				queue.add(n.next);
			}
		}

		return head;

	}

	public static class LNComparator implements Comparator<ListNode> {

		public int compare(ListNode arg0, ListNode arg1) {

			return arg0.val - arg1.val;
		}

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
