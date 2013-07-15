package q.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import util.Question;

public class FlattenBinaryTreeToLinkedList extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a binary tree, flatten it to a linked list in-place.
		 */
		return "http://leetcode.com/onlinejudge#question_114";
	}

	public void flatten(TreeNode root) {

		if (root == null)
			return;

		TreeNode pre = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);

		Set<TreeNode> visited = new HashSet<TreeNode>();

		while (!stack.isEmpty()) {

			TreeNode n = stack.peek();

			if (!visited.contains(n)) {

				if (pre != null) {
					pre.left = n;
				}
				pre = n;

				visited.add(n);

			} else if (n.left != null && !visited.contains(n.left)) {
				stack.add(n.left);
			} else if (n.right != null && !visited.contains(n.right)) {
				stack.add(n.right);
			} else {
				stack.pop();
			}
		}

		while (root != null) {
			root.right = root.left;
			root.left = null;
			root = root.right;
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
