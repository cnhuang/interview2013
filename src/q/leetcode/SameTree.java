package q.leetcode;

import util.Question;

public class SameTree extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given two binary trees, write a function to check if they are equal
		 * or not.
		 * 
		 * Two binary trees are considered equal if they are structurally
		 * identical and the nodes have the same value.
		 */
		return "http://leetcode.com/onlinejudge#question_100";
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		
		
		if(p == null && q == null)
			return true;
		
		if(p != null && q != null){
			return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
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
