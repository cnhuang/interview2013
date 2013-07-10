package q.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ds.TreeNode;

import util.Question;

public class LargestBSTSubTree extends Question {

	@Override
	public String getQuestion() {

		return "http://leetcode.com/2010/11/largest-binary-search-tree-bst-in.html";
	}

	@Test(dataProvider = "dataProvider")
	public void test(TreeNode<Integer> root) {

		Log("Input:" + root.print());
		Result r = find(root);
		Log("Out:" + r.maxTree.selfTree.print());

	}

	public Result find(TreeNode<Integer> node) {

		Result r = new Result();
		TreeNode<Integer> clone = new TreeNode<Integer>(node.data);
		r.selfTree = clone;
		r.size = 1;

		Result left = null;
		if (node.left != null) {

			left = find(node.left);

			if (node.data > node.left.data) {
				r.selfTree.left = left.selfTree;
				r.size += left.size;
			}
		}

		Result right = null;
		if (node.right != null) {

			right = find(node.right);

			if (node.data < node.right.data) {

				r.selfTree.right = right.selfTree;
				r.size += right.size;
			}
		}

		Result max = r;

		if (left != null && max.size < left.maxTree.size)
			max = left;

		if (right != null && max.size < right.maxTree.size)
			max = right;

		r.maxTree = max;

		return r;

	}

	public static class Result {
		TreeNode<Integer> selfTree;
		Result maxTree;
		int size;
	}

	@DataProvider
	public static Object[][] dataProvider() {

		TreeNode<Integer> N1 = new TreeNode<Integer>(1);
		TreeNode<Integer> N5 = new TreeNode<Integer>(5);
		TreeNode<Integer> N8 = new TreeNode<Integer>(8);
		TreeNode<Integer> N10 = new TreeNode<Integer>(3);
		TreeNode<Integer> N15 = new TreeNode<Integer>(15);
		TreeNode<Integer> N7 = new TreeNode<Integer>(7);

		N5.left = N1;
		N5.right = N8;
		N10.left = N5;
		N10.right = N15;
		N15.right = N7;

		return new Object[][] { { N10 } };

	}

}
