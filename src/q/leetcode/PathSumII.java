package q.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import util.Question;

public class PathSumII extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a binary tree and a sum, find all root-to-leaf paths where each
		 * path's sum equals the given sum.
		 */
		return "http://leetcode.com/onlinejudge#question_113";
	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		int count = 0;

		Set<TreeNode> visited = new HashSet<TreeNode>();

		while (!stack.isEmpty()) {

			TreeNode n = stack.peek();

			if (!visited.contains(n)) {

				count += n.val;

				if (n.left == null && n.right == null && count == sum){
					
					ArrayList<Integer> r = new ArrayList<Integer>();
					for(int i = 0 ; i < stack.size() ; i++){
						r.add(stack.get(i).val);
					}
					result.add(r);
				}

				visited.add(n);

			} else if (n.left != null && !visited.contains(n.left)) {
				stack.add(n.left);
			} else if (n.right != null && !visited.contains(n.right)) {
				stack.add(n.right);
			} else {
				count -= stack.pop().val;
			}

		}

		return result;

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
