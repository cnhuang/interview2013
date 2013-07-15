package q.leetcode;

import org.testng.annotations.Test;

import util.Question;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal extends
		Question {

	@Override
	public String getQuestion() {
		/*
		 * Given preorder and inorder traversal of a tree, construct the binary
		 * tree.
		 */
		return "http://leetcode.com/onlinejudge#question_105";
	}

	@Test
	public void test(){
		buildTree(new int[]{1,4,3,2},new int[]{1,2,3,4});
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {

		return buildTree(preorder, inorder, 0, 0, inorder.length - 1);

	}

	public TreeNode buildTree(int[] preorder, int[] inorder, int preS, int inS,
			int inE) {
	
		if (inS > inE)
			return null;

		TreeNode n = new TreeNode(preorder[preS]);

		for (int i = inS; i <= inE; i++) {
			if (inorder[i] == preorder[preS]) {
				int length = i - inS;
				n.left = buildTree(preorder, inorder, preS + 1, inS, i - 1);
				n.right = buildTree(preorder, inorder, preS + length + 1, i + 1,
						inE);
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
