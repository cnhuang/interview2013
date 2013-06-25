package q.com.amzn;

import java.util.Stack;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

import ds.TreeNode;

public class BSTtoDoubleLinkedList extends Question {

	@Override
	public String getQuestion() {
		return "Rebuild a tree";
	}

	@Test(dataProvider = "dataProvider")
	public void convert(TreeNode<Integer> root) {

		TreeNode<Integer> head = null;
		TreeNode<Integer> parent = null;

		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
		stack.push(root);

		while (!stack.isEmpty()) {

			TreeNode<Integer> node = stack.peek();

			if (node.left != null && !node.left.visited) {
				stack.add(node.left);

			} else if (!node.visited) {

				node.visited = true;
				node.left = parent;

				if (parent != null) {
					parent.right = node;
				}

				if (head == null)
					head = node;

				parent = node;

			} else if (node.right != null && !node.right.visited) {
				stack.add(node.right);
			} else
				stack.pop();
		}

		verify(head);

	}

	@Test(dataProvider = "dataProvider")
	public void convert_recursive(TreeNode<Integer> root) {
		Result r = convert_recursive2(root);
		verify(r.head);
	}

	public Result convert_recursive2(TreeNode<Integer> node) {

		if (node == null)
			return null;

		Result left = convert_recursive2(node.left);
		Result right = convert_recursive2(node.right);

		Result result = new Result();

		if (left != null) {
			result.head = left.head;
			left.tail.right = node;
			node.left = left.tail;
		} else {
			result.head = node;
			node.left = null;
		}

		if (right != null) {
			node.right = right.head;
			right.head.left = node;
			result.tail = right.tail;
		} else {
			result.tail = node;
			node.right = null;
		}

		return result;
	}

	public static class Result {
		TreeNode<Integer> head;
		TreeNode<Integer> tail;
	}

	private void verify(TreeNode<Integer> node) {

		Log("Verify");
		TreeNode<Integer> last = node;
		String s = "";
		while (node != null) {
			s += node.toString() + ",";
			last = node;
			node = node.right;
		}

		Log(s);
		s = "";
		node = last;
		while (node != null) {
			s += node.toString() + ",";
			node = node.left;
		}
		Log(s+"\n");
	}

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		return new Object[][] { { TreeNode.getBinarySearchTree() } };
	}

}
