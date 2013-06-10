package q.com.google;

import java.util.Stack;

import ds.TreeNode;
import util.Question;

public class FindMostFreqItemInBST extends Question {

	/**
	 * Inorder traversial
	 */
	@Override
	public String getQuestion() {
		return "http://www.careercup.com/question?id=17192662";
	}

	public void find(TreeNode<Integer> root) {

		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
		stack.add(root);

		Integer max = null;
		int maxCount = 0;

		Integer current = null;
		int count = 0;

		while (stack.size() != 0) {

			TreeNode<Integer> node = stack.peek();

			if (node.left != null && !node.left.visited)
				stack.push(node.left);
			else if (!node.visited) {

				node.visited = true;

				if (current == null || current != node.data) {
					current = node.data;
					count = 1;
				} else {
					count++;

					if (count > max) {
						max = current;
						maxCount = count;
					}
				}

			} else if (node.right != null && !node.right.visited) {
				stack.push(node.right);
			} else {
				stack.pop();
			}
		}

		Log("MaxItem:" + max + ", count:" + maxCount);
	}
}
