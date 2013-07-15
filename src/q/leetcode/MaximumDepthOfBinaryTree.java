package q.leetcode;

import q.leetcode.BinaryTreeLevelOrderTraversal.TreeNode;
import util.Question;

public class MaximumDepthOfBinaryTree extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a binary tree, find its maximum depth.
		 * 
		 * The maximum depth is the number of nodes along the longest path from
		 * the root node down to the farthest leaf node.
		 */
		return "http://leetcode.com/onlinejudge#question_104";
	}

	public int maxDepth(TreeNode root) {

		if (root == null)
			return 0;

		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

	}

}
