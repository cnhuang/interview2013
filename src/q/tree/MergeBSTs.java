package q.tree;

import java.util.Stack;

import org.testng.annotations.Test;

import ds.TreeNode;

import util.Question;

public class MergeBSTs extends Question {

	@Override
	public String getQuestion() {
		return "Merge 2 BSTs";
	}

	@Test
	public void merge_simple(TreeNode<Integer> tree1, TreeNode<Integer> tree2) {

		// traverse and store all node in 2 arrays and do external sort
	}

	@Test
	public void merge(TreeNode<Integer> tree1, TreeNode<Integer> tree2) {

		// http://stackoverflow.com/questions/7540546/merging-2-binary-search-trees
	}

	@Test
	public void merge_old(TreeNode<Integer> t1, TreeNode<Integer> t2) {
		Stack<TreeNode<Integer>> s1 = new Stack<TreeNode<Integer>>();
		Stack<TreeNode<Integer>> s2 = new Stack<TreeNode<Integer>>();

		s1.add(t1);
		s2.add(t2);
		ToMin(s1);
		ToMin(s2);

		TreeNode<Integer> head = null;

		while (!s1.empty() || !s2.empty()) {

			TreeNode<Integer> n1 = null;
			TreeNode<Integer> n2 = null;

			if (!s1.empty())
				n1 = s1.peek();

			if (!s2.empty())
				n2 = s2.peek();

			TreeNode<Integer> minNode = null;

			if (n1 == null)
				minNode = n2;
			else if (n2 == null)
				minNode = n1;
			else if (n2.data < n1.data)
				minNode = n2;
			else
				minNode = n1;

			minNode.visited = true;

			if (head == null) {
				head = minNode;
			} else {
				if (head.data > minNode.data) {
					minNode.left = head.left;
					head.left = minNode;
				} else {
					minNode.left = head;
					head = minNode;
				}
			}

			ToMin(s1);
			ToMin(s2);

		}

		TreeNode<Integer> t = head;
		while (t != null) {
			t.visited = false;
			t.right = null;
			t = t.left;
		}

		Log(head.print());

	}

	public static void ToMin(Stack<TreeNode<Integer>> s) {
		while (!s.empty()) {
			TreeNode<Integer> n = s.peek();
			if (n.left != null && !n.left.visited) {
				s.add(n.left);
			} else if (!n.visited) {
				return;
			} else if (n.right != null && !n.right.visited) {
				s.add(n.right);
			} else {
				s.pop();
			}
		}
	}

}
