package q.leetcode;

import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.Test;

import ds.TreeNode;
import util.Question;

public class UseDFSToRealizeBFS extends Question {

	@Override
	public String getQuestion() {
		/**
		 * Given a binary tree, print out the tree in level order (ie, from left
		 * to right, level by level). Output a newline after the end of each
		 * level. Breadth First Search (BFS) is not allowed.
		 * 
		 * O(NlogN)
		 * 
		 * = logN(lv0) + LogN-1*2(lv1) + LogN-2*4(lv2) + .. + 1*2^LogN (lvLogN)
		 * 
		 * <= logN(1+2+4+...+2^LogN) 
		 * 
		 * = (logN)*(1-r^logN)/(1-r), r = 2 => (logN)N-1/1 = NlogN
		 */
		return "http://leetcode.com/2010/09/binary-tree-level-order-traversal-using_17.html";
	}

	@Test
	public void print() {
		TreeNode<Integer> root = TreeNode.getSimpleTree(15);
		Log(root.print());

		int h = getHeight(root);

		for (int i = 0; i < h; i++) {
			List<Integer> r = new LinkedList<Integer>();
			print(root, 0, i, r);
			Log(i + ":" + r);
		}
	}

	public void print(TreeNode<Integer> n, int level, int target, List<Integer> r) {

		if (n == null)
			return;

		if (level == target) {
			r.add(n.data);
			return;
		}

		print(n.left, level + 1, target, r);
		print(n.right, level + 1, target, r);
	}

	private int getHeight(TreeNode<Integer> n) {

		if (n == null)
			return 0;

		return Math.max(getHeight(n.left), getHeight(n.right)) + 1;

	}

}
