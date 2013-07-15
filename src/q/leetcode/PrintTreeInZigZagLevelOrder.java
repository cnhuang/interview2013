package q.leetcode;

import java.util.ArrayList;
import java.util.Stack;

import util.Question;

public class PrintTreeInZigZagLevelOrder extends Question {

	@Override
	public String getQuestion() {

		/*
		 * Given a binary tree, return the zigzag level order traversal of its
		 * nodes' values. (ie, from left to right, then right to left for the
		 * next level and alternate between).
		 * 
		 * For example: Given binary tree {3,9,20,#,#,15,7},
		 * 
		 * [ [3], [20,9], [15,7] ]
		 */
		// http://leetcode.com/onlinejudge#question_103
		return "http://leetcode.com/2010/09/printing-binary-tree-in-zig-zag-level_18.html";
	}

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (root == null)
			return result;

		Stack<TreeNode> currLv = new Stack<TreeNode>();
		Stack<TreeNode> nextLv = null;

		int level = 0;
		currLv.add(root);

		while (!currLv.isEmpty()) {

			nextLv = new Stack<TreeNode>();
			ArrayList<Integer> r = new ArrayList<Integer>();

			while (!currLv.isEmpty()) {

				TreeNode n = currLv.pop();

				if (n == null)
					continue;

				r.add(n.val);

				if (level % 2 == 0) {
					nextLv.add(n.left);
					nextLv.add(n.right);
				} else {
					nextLv.add(n.right);
					nextLv.add(n.left);
				}
			}

			if (r.size() > 0)
				result.add(r);
			level++;
			currLv = nextLv;
		}

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
