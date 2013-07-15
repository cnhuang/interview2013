package q.leetcode;

import util.Question;

public class ConvertSortedArrayToBinarySearchTree extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given an array where elements are sorted in ascending order, convert
		 * it to a height balanced BST.
		 */
		return "http://leetcode.com/onlinejudge#question_108";
	}

	public TreeNode sortedArrayToBST(int[] num) {

		if (num == null || num.length == 0) {
			return null;
		}

		return sortedArrayToBST(num, 0, num.length - 1);

	}

	public TreeNode sortedArrayToBST(int[] num, int s, int e) {

		if (s > e)
			return null;

		int mid = (s + e) / 2;
		TreeNode n = new TreeNode(num[mid]);

		n.left = sortedArrayToBST(num, s, mid - 1);
		n.right = sortedArrayToBST(num, mid + 1, e);

		return n;

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
