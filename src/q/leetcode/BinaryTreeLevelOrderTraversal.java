package q.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import util.Question;

public class BinaryTreeLevelOrderTraversal extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a binary tree, return the level order traversal of its nodes'
		 * values. (ie, from left to right, level by level).
		 * 
		 * For example: Given binary tree {3,9,20,#,#,15,7},
		 * 
		 * 
		 * [ [3], [9,20], [15,7] ]
		 */
		return "http://leetcode.com/onlinejudge#question_102";
	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		ArrayList<Integer> r = new ArrayList<Integer>();

		while (!queue.isEmpty()) {

			TreeNode n = queue.poll();

			if (n == null) {
				continue;
			}

			r.add(n.val);

			if (n.left != null)
				queue.add(n.left);
			if (n.right != null)
				queue.add(n.right);

			if (queue.peek() == null) {
				result.add(r);
				r = new ArrayList<Integer>();
				queue.add(null);
			}
		}

		if (r.size() > 0)
			result.add(r);

		return result;
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
