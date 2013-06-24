package q.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import q.tree.DFS;

import ds.Node;
import ds.TreeNode;

import util.Question;
import util.Wrapper;

public class LinkedListToBalancedBST extends Question {

	@Override
	public String getQuestion() {
		return "http://leetcode.com/2010/11/convert-sorted-list-to-balanced-binary.html";
	}

	@Test(dataProvider = "dataProvider")
	public void build(Node<Integer> head, int size) {

		Log("Input:" + head);
		Wrapper<Node<Integer>> wrapper = new Wrapper<Node<Integer>>(head);
		wrapper.obj = head;
		TreeNode<Integer> tree = build_recursive(wrapper, 0, size - 1);
		Log(DFS.iterative_InOrder(tree));
	}

	public TreeNode<Integer> build_recursive(Wrapper<Node<Integer>> wrapper,
			int s, int e) {

		if (s > e) {
			return null;
		}

		int mid = (s + e) / 2;

		TreeNode<Integer> left = build_recursive(wrapper, s, mid - 1);
		TreeNode<Integer> node = new TreeNode<Integer>(wrapper.obj.data);
		node.left = left;
		wrapper.obj = wrapper.obj.next;
		node.right = build_recursive(wrapper, mid + 1, e);
		return node;
	}

	@DataProvider
	public static Object[][] dataProvider() {

		Node<Integer> head = new Node<Integer>(0);
		Node<Integer> curr = head;

		for (int i = 1; i < 20; i++) {
			Node<Integer> n = new Node<Integer>(i);
			curr.next = n;
			curr = n;
		}

		return new Object[][] { { head, 20 } };

	}

}
