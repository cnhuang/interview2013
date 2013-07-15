package q.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import util.Question;

public class PopulatingNextRightPointersInEachNode2 extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Follow up for problem "Populating Next Right Pointers in Each Node".
		 * 
		 * What if the given tree could be any binary tree? Would your previous
		 * solution still work?
		 * 
		 * Note:
		 * 
		 * You may only use constant extra space.
		 */
		return "http://leetcode.com/onlinejudge#question_117";
	}

	@Test
	public void test() {

		TreeLinkNode n0 = new TreeLinkNode(0);
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(5);
		TreeLinkNode n6 = new TreeLinkNode(6);
		TreeLinkNode n7 = new TreeLinkNode(7);
		TreeLinkNode n8 = new TreeLinkNode(8);
		TreeLinkNode n9 = new TreeLinkNode(9);
		TreeLinkNode n10 = new TreeLinkNode(10);
		TreeLinkNode n11 = new TreeLinkNode(11);
		TreeLinkNode n12 = new TreeLinkNode(12);

		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		n3.left = n7;
		n4.left = n8;
		n4.right = n9;
		n6.left = n10;
		n6.right = n11;
		n9.left = n12;

		connect(n0);

	}

	public void connect(TreeLinkNode root) {

		if (root == null)
			return;

		List<TreeLinkNode> nodes = new ArrayList<TreeLinkNode>();

		if (root.left != null) {
			nodes.add(root.left);
		}

		if (root.right != null) {
			nodes.add(root.right);
		}

		TreeLinkNode next = root.next;

		while (next != null && next.left == null && next.right == null) {
			next = next.next;
		}

		if (next != null) {
			if (next.left != null) {
				nodes.add(next.left);
			} else if (next.right != null) {
				nodes.add(next.right);
			}
		}

		for (int i = nodes.size() - 2; i >= 0; i--) {
			nodes.get(i).next = nodes.get(i + 1);
		}

		//important. right first
		connect(root.right);
		connect(root.left);

	}

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
		
		public String toString(){
			return String.valueOf(val);
		}
	}

}
