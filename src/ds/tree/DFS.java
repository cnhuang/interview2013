package ds.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class DFS extends Question {

	@Override
	public String getQuestion() {
		return "DFS";
	}

	@Test(dataProvider = "dataProvider")
	public void testDFS(TreeNode<Integer> root) {

		Log("Input:\n" + root.print());

		Log("iterative_PreOrder:" + iterative_PreOrder(root));
		Log("iterative_InOrder:" + iterative_InOrder(root));
		Log("iterative_PostOrder:" + iterative_PostOrder(root));
	}

	public static List<TreeNode<Integer>> iterative_InOrder(TreeNode<Integer> root) {

		TreeNode.cleanVisited(root);
		List<TreeNode<Integer>> result = new LinkedList<TreeNode<Integer>>();
		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
		stack.add(root);

		while (stack.size() > 0) {

			TreeNode<Integer> node = stack.peek();
			if (node.left != null && !node.left.visited) {
				stack.push(node.left);
			} else {

				if (!node.visited) {
					result.add(node);
					node.visited = true;
				}

				if (node.right != null && !node.right.visited) {
					stack.push(node.right);
				} else {
					stack.pop();
				}
			}
		}

		TreeNode.cleanVisited(root);
		return result;
	}

	public static List<TreeNode<Integer>> iterative_PostOrder(TreeNode<Integer> root) {

		TreeNode.cleanVisited(root);
		List<TreeNode<Integer>> result = new LinkedList<TreeNode<Integer>>();
		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
		stack.add(root);

		while (stack.size() > 0) {

			TreeNode<Integer> node = stack.peek();

			if (node.left != null && !node.left.visited) {
				stack.push(node.left);
			} else if (node.right != null && !node.right.visited) {
				stack.push(node.right);
			} else {
				node.visited = true;
				result.add(node);
				stack.pop();
			}
		}

		TreeNode.cleanVisited(root);
		return result;
	}

	public static List<TreeNode<Integer>> iterative_PreOrder(TreeNode<Integer> root) {

		TreeNode.cleanVisited(root);
		List<TreeNode<Integer>> result = new LinkedList<TreeNode<Integer>>();
		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();

		stack.add(root);

		while (stack.size() > 0) {

			TreeNode<Integer> node = stack.peek();

			if (!node.visited) {
				result.add(node);
				node.visited = true;
			}

			if (null != node.left && !node.left.visited)
				stack.push(node.left);
			else if (null != node.right && !node.right.visited)
				stack.push(node.right);
			else
				stack.pop();

		}
		
		TreeNode.cleanVisited(root);
		return result;

	}

	@DataProvider
	public static Object[][] dataProvider() {

		return new Object[][] { { TreeNode.getRandomTree() } };
	}

}
