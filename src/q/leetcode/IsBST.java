package q.leetcode;

import java.util.Stack;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import q.tree.DFS;

import ds.TreeNode;
import util.Question;

public class IsBST extends Question {

	@Override
	public String getQuestion() {
		return "http://leetcode.com/2010/09/determine-if-binary-tree-is-binary.html";
	}

	@Test(dataProvider = "dataProvider")
	public void isBST(TreeNode<Integer> root) {

		Log("Input:" + DFS.iterative_InOrder(root));

		int last = Integer.MIN_VALUE;

		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
		stack.add(root);
		boolean pass = true;

		while (!stack.isEmpty() && pass) {

			TreeNode<Integer> n = stack.peek();
			if (n.left != null && !n.left.visited)
				stack.add(n.left);
			else if (!n.visited) {
				if (last <= n.data)
					last = n.data;
				else
					pass = false;

				n.visited = true;
			} else if (n.right != null && !n.right.visited)
				stack.add(n.right);
			else
				stack.pop();

		}
		Log("BST:" + pass);
	}

	@DataProvider
	public static Object[][] dataProvider() {

		return new Object[][] { { TreeNode.getBinarySearchTree() }, { TreeNode.getRandomTree() } };
	}

}
