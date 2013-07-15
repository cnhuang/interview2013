package q.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import util.Question;

public class BinaryTreeLevelOrderTraversalII extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a binary tree, return the bottom-up level order traversal of
		 * its nodes' values. (ie, from left to right, level by level from leaf
		 * to root).
		 * 
		 * For example: Given binary tree {3,9,20,#,#,15,7},
		 * 
		 * [ [15,7] [9,20], [3], ]
		 */
		return "http://leetcode.com/onlinejudge#question_107";
	}

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (root == null) {
			return result;
		}

		int depth = maxDepth(root);
		
		for(int i = 0 ; i < depth ; i++)
			result.add(new ArrayList<Integer>());
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);

		Set<TreeNode> visited = new HashSet<TreeNode>();

		while (!stack.isEmpty()) {

			TreeNode n = stack.peek();

			if (n.left != null && !visited.contains(n.left)) {
				stack.add(n.left);
			} else if (!visited.contains(n)) {
				visited.add(n);
				int level = depth- stack.size() ;
				result.get(level).add(n.val);

			} else if (n.right != null && !visited.contains(n.right)) {
				stack.add(n.right);
			} else {
				stack.pop();
			}

		}

		return result;

	}

	public int maxDepth(TreeNode n) {
		if (n == null)
			return 0;

		return Math.max(maxDepth(n.left), maxDepth(n.right)) + 1;
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
