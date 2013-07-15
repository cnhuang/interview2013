package q.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import util.Question;

public class MinimumDepthOfBinaryTree extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a binary tree, find its minimum depth.
		 * 
		 * The minimum depth is the number of nodes along the shortest path from
		 * the root node down to the nearest leaf node.
		 */
		return "http://leetcode.com/onlinejudge#question_111";
	}

	public int minDepth(TreeNode root) {

		if (root == null)
			return 0;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);

		int depth = 1;

		while (!queue.isEmpty()) {

			Queue<TreeNode> next = new LinkedList<TreeNode>();

			while (!queue.isEmpty()) {

				TreeNode n = queue.poll();

				if (n.left == null && n.right == null)
					return depth;

				if (n.left != null)
					next.add(n.left);

				if (n.right != null)
					next.add(n.right);
			}

			depth++;
			queue = next;
		}

		return depth;

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
