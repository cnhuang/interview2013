package q.leetcode;

import java.util.Stack;

import org.testng.annotations.Test;

import ds.TreeNode;
import util.Question;

public class PrintTreeInZigZagLevelOrder extends Question {

	@Override
	public String getQuestion() {
		return "http://leetcode.com/2010/09/printing-binary-tree-in-zig-zag-level_18.html";
	}

	@Test
	public void print() {
		TreeNode<Integer> root = TreeNode.getSimpleTree(15);
		Log(root.print());

		Stack<TreeNode<Integer>> currLv = new Stack<TreeNode<Integer>>();
		Stack<TreeNode<Integer>> nextLv = null;

		int level = 0;
		currLv.add(root);

		while (!currLv.isEmpty()) {

			nextLv = new Stack<TreeNode<Integer>>();
			String s = "";
			while (!currLv.isEmpty()) {
				TreeNode<Integer> n = currLv.pop();
				if (n == null)
					continue;
				s += n.data + ",";
				if (level % 2 == 0) {
					nextLv.add(n.left);
					nextLv.add(n.right);
				} else {
					nextLv.add(n.right);
					nextLv.add(n.left);
				}
			}

			Log(s);
			level++;
			currLv = nextLv;
		}
	}

}
