package q.leetcode;

import util.Question;

public class SymmetricTree extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a binary tree, check whether it is a mirror of itself (ie,
		 * symmetric around its center).
		 */
		return "http://leetcode.com/onlinejudge#question_101";
	}

	public boolean isSymmetric(TreeNode root) {

		if(root == null)
			return true;
		
		return isSymmetric(root.left,root.right);
		
	}

	public boolean isSymmetric(TreeNode p, TreeNode q) {

		if (p == null && q == null)
			return true;

		if (p != null && q != null) {
			return p.val == q.val && isSymmetric(p.left, q.right)
					&& isSymmetric(p.right, q.left);
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
