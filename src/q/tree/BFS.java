package q.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ds.TreeNode;

import util.Question;

public class BFS extends Question {

	@Override
	public String getQuestion() {
		return "BFS";
	}

	@Test(dataProvider = "dataProvider")
	public void testBFS(TreeNode<Integer> root) {

		Log("Input:\n" + root.print());
		Log("IterativeAppraoch:" + iterativeAppraoch(root));
		Log("RecursiveApproach:" + recursiveApproach(root));
	}

	private List<Integer> iterativeAppraoch(TreeNode<Integer> root) {

		List<Integer> result = new LinkedList<Integer>();
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		queue.add(root);

		while (queue.size() > 0) {

			TreeNode<Integer> node = queue.poll();
			result.add(node.data);

			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
		return result;
	}

	private List<Integer> recursiveApproach(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		List<Integer> result = new LinkedList<Integer>();
		queue.add(root);
		recursiveApproach_recursive(queue, result);
		return result;
	}

	private void recursiveApproach_recursive(Queue<TreeNode<Integer>> queue, List<Integer> result) {

		if (queue.size() == 0)
			return;

		Queue<TreeNode<Integer>> queue2 = new LinkedList<TreeNode<Integer>>();

		while (queue.size() != 0) {
			TreeNode<Integer> node = queue.poll();
			result.add(node.data);

			if (node.left != null)
				queue2.add(node.left);
			if (node.right != null)
				queue2.add(node.right);
		}

		recursiveApproach_recursive(queue2, result);
	}

	@DataProvider
	public static Object[][] dataProvider() {

		return new Object[][] { { TreeNode.getRandomTree() } };
	}

}
