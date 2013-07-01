package q.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import org.testng.annotations.Test;

import ds.TreeNode;

import util.Question;

public class PopulateNextRightPointers extends Question {

	@Override
	public String getQuestion() {
		return "http://leetcode.com/2010/03/first-on-site-technical-interview.html";
	}

	@Test
	public void populate_bfs() {

		Node root = Node.create(20);
		Log(root.print());

		Queue<Node> q = new LinkedList<Node>();
		Queue<Node> child = new LinkedList<Node>();

		q.add(root);

		while (!q.isEmpty()) {

			Node n = q.poll();

			n.nextRight = q.peek();

			if (n.left != null) {
				child.add((Node) n.left);
			}
			if (n.right != null) {
				child.add((Node) n.right);
			}

			if (q.isEmpty()) {
				q = child;
				child = new LinkedList<Node>();
			}
		}

		while (root != null) {
			Log(root.printNextRight());
			root = (Node) root.left;
		}
	}

	@Test
	public void populate_recursive() {

		Node root = Node.create(20);
		Log(root.print());
		populate_recursive(root);

		while (root != null) {
			Log(root.printNextRight());
			root = (Node) root.left;
		}
	}

	private void populate_recursive(Node n) {

		if (n == null)
			return;

		if (n.left != null)
			((Node) n.left).nextRight = (Node) n.right;

		if (n.right != null)
			((Node) n.right).nextRight = (Node) (n.nextRight == null ? null : n.nextRight.left);

		populate_recursive((Node) n.left);
		populate_recursive((Node) n.right);
	}

	private static class Node extends TreeNode<Integer> {

		Node nextRight;

		public Node(int i) {
			super(i);
		}

		public static Node create(int i) {

			Node root = new Node(0);
			Queue<Node> q = new LinkedList<Node>();

			q.add(root);
			int count = 1;

			while (!q.isEmpty()) {

				Node n = q.poll();

				if (count < i) {
					n.left = new Node(count++);
					q.add((Node) n.left);
				} else
					break;

				if (count < i) {
					n.right = new Node(count++);
					q.add((Node) n.right);
				} else
					break;

			}
			return root;
		}

		public String printNextRight() {

			String s = data + "->";
			if (nextRight != null)
				s += nextRight.printNextRight();
			return s;

		}
	}

}
