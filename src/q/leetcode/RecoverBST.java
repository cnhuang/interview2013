package q.leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import util.Question;

public class RecoverBST extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Two elements of a binary search tree (BST) are swapped by mistake.
		 * 
		 * Recover the tree without changing its structure.
		 * 
		 * Note: A solution using O(n) space is pretty straight forward. Could
		 * you devise a constant space solution?
		 */
		// http://fisherlei.blogspot.com/2012/12/leetcode-recover-binary-search-tree.html

		return "http://leetcode.com/onlinejudge#question_99";
	}

	public void recoverTree(TreeNode root) {

		if (root == null)
			return;

		recoverTree_N_Space(root);

	}

	public void recoverTree_1_Space(TreeNode root) {

		TreeNode first = null;
		TreeNode second = null;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		Set<TreeNode> visited = new HashSet<TreeNode>();
		stack.add(root);
		TreeNode prev = null;

		while (!stack.isEmpty()) {

			TreeNode n = stack.peek();

			if (n.left != null && !visited.contains(n.left)) {
				stack.add(n.left);
			} else if (!visited.contains(n)) {

				visited.add(n);

				if (prev == null)
					prev = n;
				else if (n.val < prev.val) {
					if (first == null) {
						first = prev;
						second = n;
					} else {
						second = n;
						break;
					}
				} 
				prev = n;

			} else if (n.right != null && !visited.contains(n.right)) {
				stack.add(n.right);
			} else {
				stack.pop();
			}
		}

		if (first != null) {
			int tmp = first.val;
			first.val = second.val;
			second.val = tmp;
		}
	}

	public void recoverTree_N_Space(TreeNode root) {

		List<Integer> data = new LinkedList<Integer>();

		traverse(root, data, true);

		Collections.sort(data);

		traverse(root, data, false);

	}

	public void traverse(TreeNode root, List<Integer> data, boolean read) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		Set<TreeNode> visited = new HashSet<TreeNode>();
		stack.add(root);

		while (!stack.isEmpty()) {

			TreeNode n = stack.peek();

			if (n.left != null && !visited.contains(n.left)) {
				stack.add(n.left);
			} else if (!visited.contains(n)) {
				visited.add(n);
				if (read)
					data.add(n.val);
				else
					n.val = data.remove(0);
			} else if (n.right != null && !visited.contains(n.right)) {
				stack.add(n.right);
			} else {
				stack.pop();
			}
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
