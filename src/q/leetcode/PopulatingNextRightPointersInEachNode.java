package q.leetcode;

import util.Question;

public class PopulatingNextRightPointersInEachNode extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a binary tree
		 * 
		 * struct TreeLinkNode { TreeLinkNode *left; TreeLinkNode *right;
		 * TreeLinkNode *next; } Populate each next pointer to point to its next
		 * right node. If there is no next right node, the next pointer should
		 * be set to NULL.
		 * 
		 * Initially, all next pointers are set to NULL.
		 * 
		 * Note:
		 * 
		 * You may only use constant extra space. You may assume that it is a
		 * perfect binary tree (ie, all leaves are at the same level, and every
		 * parent has two children).
		 */
		return "http://leetcode.com/onlinejudge#question_116";
	}

	public void connect(TreeLinkNode root) {
		
		if(root == null)
			return;
		
		if(root.left != null){
			root.left.next = root.right;
		}
		
		if(root.right != null && root.next != null){
			root.right.next = root.next.left;
		}
		
		connect(root.left);
		connect(root.right);
		
	}
	

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

}
