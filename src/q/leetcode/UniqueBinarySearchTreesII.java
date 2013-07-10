package q.leetcode;

import java.util.ArrayList;

import util.Question;

public class UniqueBinarySearchTreesII extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given n, how many structurally unique BST's (binary search trees)
		 * that store values 1...n?
		 * 
		 * For example, Given n = 3, there are a total of 5 unique BST's.
		 */
		return "http://leetcode.com/onlinejudge#question_91";
	}

	public ArrayList<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}

	public ArrayList<TreeNode> generateTrees(int s, int e) {

		ArrayList<TreeNode> result = new ArrayList<TreeNode>();

		if (s > e) {

			result.add(null);
			return result;
		}

		for (int i = s; i <= e; i++) {

			ArrayList<TreeNode> lefts = generateTrees(s, i - 1);
			ArrayList<TreeNode> rights = generateTrees(i + 1, e);

			for (TreeNode left : lefts) {
				for (TreeNode right : rights) {

					TreeNode t = new TreeNode(i);
					t.left = left;
					t.right = right;
					result.add(t);
				}
			}

		}

		return result;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}
}
