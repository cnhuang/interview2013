package q.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ds.TreeNode;

import util.Question;

public class DFS extends Question {

	@Override
	public String getQuestion() {
		return "DFS";
	}

	@Test(dataProvider = "dataProvider")
	public void testDFS(TreeNode<Integer> root) {

		//Log("Input:\n" + root.print());

		Log("iterative_PreOrder:" + iterative_PreOrder(root));
		Log("recursive_PreOrder:" + recursive_PreOrder(root));
		
		Log("iterative_InOrder:" + iterative_InOrder(root));
		Log("recursive_InOrder:" + recursive_InOrder(root));
		
		Log("iterative_PostOrder:" + iterative_PostOrder(root));
		Log("recursive_PostOrder:" + recursive_PostOrder(root));
	}

	public static List<TreeNode<Integer>> recursive_PostOrder(TreeNode<Integer> root) {

		List<TreeNode<Integer>> result = new LinkedList<TreeNode<Integer>>();

		recursive_PostOrder(root, result);

		return result;
	}

	private static void recursive_PostOrder(TreeNode<Integer> root, List<TreeNode<Integer>> result) {

		if (root == null)
			return;

		recursive_PostOrder(root.left, result);
		recursive_PostOrder(root.right, result);
		result.add(root);

	}

	public static List<TreeNode<Integer>> recursive_PreOrder(TreeNode<Integer> root) {

		List<TreeNode<Integer>> result = new LinkedList<TreeNode<Integer>>();

		recursive_PreOrder(root, result);

		return result;
	}

	private static void recursive_PreOrder(TreeNode<Integer> root, List<TreeNode<Integer>> result) {

		if (root == null)
			return;

		result.add(root);
		recursive_PreOrder(root.left, result);
		recursive_PreOrder(root.right, result);
	}

	public static List<TreeNode<Integer>> recursive_InOrder(TreeNode<Integer> root) {

		List<TreeNode<Integer>> result = new LinkedList<TreeNode<Integer>>();

		recursive_InOrder(root, result);

		return result;
	}

	private static void recursive_InOrder(TreeNode<Integer> root, List<TreeNode<Integer>> result) {

		if (root == null)
			return;

		recursive_InOrder(root.left, result);
		result.add(root);
		recursive_InOrder(root.right, result);
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
