package q.tree;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ds.TreeNode;
import util.Question;

public class IsBSF extends Question {

	@Override
	public String getQuestion() {
		return "is binary search tree?";
	}

	@Test(dataProvider = "dataProvider")
	public void find(TreeNode<Integer> node, Boolean isBSF) {

		Log("Input:" + DFS.iterative_InOrder(node));

		data lastValue = new data();
		lastValue.value = Integer.MIN_VALUE;
		assertEquals(isBSF.booleanValue(), isBST(node, lastValue));
	}

	private boolean isBST(TreeNode<Integer> node, data lastValue) {

		if (node == null)
			return true;

		if (isBST(node.left, lastValue)) {

			Log("LastValue:" + lastValue.value);
			if (lastValue.value <= node.data) {
				lastValue.value = node.data;

				return isBST(node.right, lastValue);
			}
		}

		return false;
	}

	private static class data {
		int value;
	}

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		return new Object[][] { { TreeNode.getBinarySearchTree(), false },
				{ TreeNode.getBinarySearchTree(), true } };
	}
}
