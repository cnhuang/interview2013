package q.tree;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ds.TreeNode;


import util.Question;

public class RebuildTree extends Question {

	@Override
	public String getQuestion() {
		return "Rebuild a tree";
	}

	@Test(dataProvider = "dataProvider")
	public void testRebuild(TreeNode<Integer> root) {

		Log("Input:\n" + root.print());

		List<TreeNode<Integer>> preOrder = DFS.iterative_PreOrder(root);
		List<TreeNode<Integer>> inOrder = DFS.iterative_InOrder(root);

		Log("Output:\n" + rebuild(inOrder, preOrder).print());
	}

	public static TreeNode<Integer> rebuild(List<TreeNode<Integer>> inOrder,
			List<TreeNode<Integer>> preOrder) {

		return rebuild(inOrder, preOrder, 0, 0, inOrder.size());
	}

	public static TreeNode<Integer> rebuild(List<TreeNode<Integer>> inOrder,
			List<TreeNode<Integer>> preOrder, int index, int s, int e) {

		// Log("\ninOrder:" + inOrder.subList(s, e));
		// Log("preOrder:" + preOrder);
		// Log("Index:" + index + ", s:" + s + ", e:" + e);

		if (index >= inOrder.size())
			return null;

		if (s >= e)
			return null;

		TreeNode<Integer> node = new TreeNode<Integer>(preOrder.get(index).data);

		// Log("node:" + node);

		for (int i = s; i < e; i++) {
			if (inOrder.get(i).data == node.data) {
				// Log("node " + node + " left:");
				node.left = rebuild(inOrder, preOrder, index + 1, s, i);

				// Log("node " + node + " right:");
				node.right = rebuild(inOrder, preOrder, index + i - s + 1, i + 1, e);
				break;
			}
		}

		return node;
	}

	@DataProvider
	public static Object[][] dataProvider() {

		return new Object[][] { { TreeNode.getRandomTree() } };
	}
}
