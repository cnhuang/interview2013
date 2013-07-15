package q.leetcode;

import org.testng.annotations.Test;

import util.Question;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal extends
		Question {

	@Override
	public String getQuestion() {
		/*
		 * Given inorder and postorder traversal of a tree, construct the binary
		 * tree.
		 */
		return "http://leetcode.com/onlinejudge#question_106";
	}

	@Test
	public void test() {
		buildTree(new int[] { 2, 1 }, new int[] { 2, 1 });
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {

		return buildTree(postorder, inorder, postorder.length - 1, 0,
				inorder.length - 1);

	}

	public TreeNode buildTree(int[] postorder, int[] inorder, int postIndex,
			int inS, int inE) {

		Log(postIndex+","+inS+","+inE);
		
		if (inS > inE)
			return null;

		TreeNode n = new TreeNode(postorder[postIndex]);

		for (int i = inS; i <= inE; i++) {
			if (inorder[i] == postorder[postIndex]) {
				int rightTreeLength = inE - i;
				
				n.right = buildTree(postorder, inorder, postIndex - 1, i + 1,
						inE);
				n.left = buildTree(postorder, inorder, postIndex - 1 - rightTreeLength,
						inS, i - 1);
				break;
			}
		}

		return n;

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
