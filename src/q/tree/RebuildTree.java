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
	public void testRebuild2(TreeNode<Integer> root) {

		// Log("Input:\n" + root.print());

		List<TreeNode<Integer>> preOrder = DFS.iterative_PreOrder(root);
		List<TreeNode<Integer>> inOrder = DFS.iterative_InOrder(root);

		Log("Input preOrder2:\n" + preOrder);
		Log("Input inOrder2:\n" + inOrder);

		TreeNode<Integer> output = rebuild2(inOrder, preOrder);

		Log("Output preOrder2:\n" + DFS.iterative_PreOrder(output));
		Log("Output inOrder2:\n" + DFS.iterative_InOrder(output));
	}

	public static TreeNode<Integer> rebuild2(List<TreeNode<Integer>> inOrder,
			List<TreeNode<Integer>> preOrder) {

		if (inOrder.size() == 0)
			return null;

		TreeNode<Integer> head = new TreeNode<Integer>(preOrder.get(0).data);

		for (int i = 0; i < inOrder.size(); i++) {

			if (inOrder.get(i).data == head.data) {

				head.left = rebuild2(inOrder.subList(0, i), preOrder.subList(1, i + 1));
				head.right = rebuild2(inOrder.subList(i + 1, inOrder.size()),
						preOrder.subList(i + 1, preOrder.size()));
			}
		}

		return head;
	}

	@Test(dataProvider = "dataProvider")
	public void testRebuild3(TreeNode<Integer> root) {

		// Log("Input:\n" + root.print());

		List<TreeNode<Integer>> preOrder = DFS.iterative_PreOrder(root);
		List<TreeNode<Integer>> inOrder = DFS.iterative_InOrder(root);

		Log("Input preOrder3:\n" + preOrder);
		Log("Input inOrder3:\n" + inOrder);

		TreeNode<Integer> output = rebuild3(inOrder, 0, preOrder, 0, inOrder.size());

		Log("Output preOrder3:\n" + DFS.iterative_PreOrder(output));
		Log("Output inOrder3:\n" + DFS.iterative_InOrder(output));
	}

	public static TreeNode<Integer> rebuild3(List<TreeNode<Integer>> inOrder, int inS,
			List<TreeNode<Integer>> preOrder, int preS, int size) {

		if (size == 0)
			return null;

		TreeNode<Integer> head = new TreeNode<Integer>(preOrder.get(preS).data);

		for (int i = 0; i < size; i++) {

			int index = inS + i;

			if (inOrder.get(index).data == head.data) {

				head.left = rebuild3(inOrder, inS, preOrder, preS + 1, i);
				head.right = rebuild3(inOrder, index + 1, preOrder, preS + 1 + i, size - i - 1);
			}
		}

		return head;

	}


	@DataProvider
	public static Object[][] dataProvider() {

		return new Object[][] { { TreeNode.getRandomTree(10) } };
	}
}
