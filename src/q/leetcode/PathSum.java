package q.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import util.Question;

public class PathSum extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a binary tree and a sum, determine if the tree has a
		 * root-to-leaf path such that adding up all the values along the path
		 * equals the given sum.
		 */
		return "http://leetcode.com/onlinejudge#question_112";
	}

	public boolean hasPathSum(TreeNode root, int sum) {

		if (root == null)
			return false;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		int count = 0;

		Set<TreeNode> visited = new HashSet<TreeNode>();

		while (!stack.isEmpty()) {

			TreeNode n = stack.peek();

			if (!visited.contains(n)) {

				count += n.val;

				if (n.left == null && n.right == null && count == sum)
					return true;

				visited.add(n);

			} else if (n.left != null && !visited.contains(n.left)) {
				stack.add(n.left);
			} else if (n.right != null && !visited.contains(n.right)) {
				stack.add(n.right);
			} else {
				count -= stack.pop().val;
			}

		}

		return false;

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
