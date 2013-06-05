package q.tree;

import org.testng.annotations.Test;

import ds.TreeNode;

import util.Question;

public class IsBalancedTree extends Question {

	@Override
	public String getQuestion() {
		return "Find if a tree is a balanced tree.";
	}

	@Test
	public void find(TreeNode<Integer> node) {

		Log("isBalanced:" + (isBalanced(node) != -1));
	}

	private int isBalanced(TreeNode<Integer> node) {

		if (node == null)
			return 0;

		int leftHeight = isBalanced(node.left);
		if (-1 == leftHeight)
			return -1;

		int rightHeight = isBalanced(node.right);
		if (-1 == rightHeight)
			return -1;

		if (Math.abs(rightHeight - leftHeight) <= 1)
			return Math.max(rightHeight, leftHeight) + 1;

		return -1;
	}

}
