package q.leetcode;

import static org.testng.AssertJUnit.assertEquals;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ds.TreeNode;

import util.Question;

public class LowestCommonAncestor extends Question {

	@Override
	public String getQuestion() {
		return null;
	}

	@Test(dataProvider = "dataProvider")
	public void find_recursive(TreeNode<Integer> root, TreeNode<Integer> n1,
			TreeNode<Integer> n2, Integer ans) {

		Log(root.print());
		Log("Find:" + n1 + ", and " + n2);
		
		TreeNode<Integer> resultNode = find_recursive(root, n1, n2);
		Log("Result:" + resultNode);
		assertEquals(ans, resultNode.data);
	}

	private TreeNode<Integer> find_recursive(TreeNode<Integer> root,
			TreeNode<Integer> n1, TreeNode<Integer> n2) {

		if (root == null)
			return new TreeNode<Integer>();

		if (n1.data == n2.data)
			return n1;

		if (n1.data == root.data || n2.data == root.data)
			return root;

		boolean n1OnLeft = isCovered(root.left, n1);
		boolean n2OnLeft = isCovered(root.left, n2);

		if (n1OnLeft != n2OnLeft) {
			return root;
		} else {
			if (n1OnLeft)
				return find_recursive(root.left, n1, n2);
			else
				return find_recursive(root.right, n1, n2);
		}
	}

	private boolean isCovered(TreeNode<Integer> root, TreeNode<Integer> n) {

		if (root == null) {
			return false;
		}

		if (root.data == n.data)
			return true;

		return isCovered(root.left, n) || isCovered(root.right, n);
	}

	@Test(dataProvider = "dataProvider")
	public void find_extraSpace(TreeNode<Integer> root, TreeNode<Integer> n1,
			TreeNode<Integer> n2, Integer ans) {

		Log(root.print());
		Log("Find:" + n1 + ", and " + n2);

		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
		stack.add(root);
		Set<Integer> set = null;
		boolean found = false;
		Integer result = null;

		if (n1.data == n2.data)
			result = n1.data;
		else {

			while (!stack.isEmpty() && !found) {

				TreeNode<Integer> node = stack.peek();

				if (node.left != null && !node.left.visited) {
					stack.add(node.left);
				} else if (node.right != null && !node.right.visited) {
					stack.add(node.right);
				} else if (!node.visited) {

					node.visited = true;

					if (node.data.equals(n1.data) || node.data.equals(n2.data)) {
						if (set == null) {
							Log("stack1:" + stack);
							set = new HashSet<Integer>();
							for (int i = 0; i < stack.size(); i++) {
								set.add(stack.get(i).data);
							}
							Log("Set:" + set);

						} else {

							Log("stack2:" + stack);
							found = true;
							for (int i = stack.size() - 1; i >= 0; i--) {
								if (set.contains(stack.get(i).data)) {
									result = stack.get(i).data;
									break;
								}
							}
						}
					}

					stack.pop();
				}

			}
		}

		TreeNode.cleanVisited(root);
		Log("Result:" + result);

		assertEquals(ans, result);
	}

	@DataProvider
	public static Object[][] dataProvider() {

		TreeNode<Integer> root = TreeNode.getSimpleTree(15);

		return new Object[][] {

		{ root, new TreeNode<Integer>(0), new TreeNode<Integer>(4), 3 },

		{ root, new TreeNode<Integer>(3), new TreeNode<Integer>(0), 3 },

		{ root, new TreeNode<Integer>(0), new TreeNode<Integer>(3), 3 },

		{ root, new TreeNode<Integer>(3), new TreeNode<Integer>(10), 7 },

		{ root, new TreeNode<Integer>(10), new TreeNode<Integer>(3), 7 },

		{ root, new TreeNode<Integer>(4), new TreeNode<Integer>(0), 3 },

		{ root, new TreeNode<Integer>(7), new TreeNode<Integer>(6), 7 },

		{ root, new TreeNode<Integer>(8), new TreeNode<Integer>(8), 8 },

		{ root, new TreeNode<Integer>(8), new TreeNode<Integer>(20), null }

		};

	}
}
