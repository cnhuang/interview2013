package q.leetcode;

import util.Question;

public class BinaryTreeMaximumPathSum extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a binary tree, find the maximum path sum.
		 * 
		 * The path may start and end at any node in the tree.
		 */
		return "http://leetcode.com/onlinejudge#question_124";
	}

	public int maxPathSum(TreeNode root) {

		Wrapper max = new Wrapper();
		maxPathSumIncludingNode(root, max);
		return max.num;

	}

	public int maxPathSumIncludingNode(TreeNode root, Wrapper max) {

		int crossRootSum = root.val;
		int notCrossMax = root.val;

		if (root.left != null) {

			int left = maxPathSumIncludingNode(root.left, max);
			max.set(left);
			crossRootSum += left;
			notCrossMax = Math.max(notCrossMax, left + root.val);
		}

		if (root.right != null) {
			int right = maxPathSumIncludingNode(root.right, max);
			max.set(right);
			crossRootSum += right;
			notCrossMax = Math.max(notCrossMax, right + root.val);
		}

		max.set(crossRootSum);
		max.set(notCrossMax);
		return notCrossMax;

	}

	public class Wrapper {
		Integer num;

		public Wrapper() {

		}

		public void set(int i) {
			if (num == null || num < i)
				num = i;
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
