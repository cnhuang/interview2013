package question;

import java.util.Stack;

import org.testng.annotations.Test;

import ds.tree.DFS;
import ds.tree.TreeNode;

import util.Question;

public class ConvertBinarySerachTreeToDoubleLinkedList extends Question {

	@Override
	public String getQuestion() {

		return "Convert a binary search tree into a double linked list. Cracking code interview 17.13";
	}

	@Test
	public void convert_additionalDS() {

		TreeNode<Integer> root = TreeNode.getBinarySearchTree();
		Log("Input (convert_additionalDS):" + DFS.iterative_InOrder(root).toString());
		MyNode node = convert_additionalDS(root);

		TreeNode<Integer> newRoot = node.min;
		while (newRoot != null) {
			Log(newRoot.toString());
			newRoot = newRoot.right;
		}
		Log("=======");
		newRoot = node.max;
		while (newRoot != null) {
			Log(newRoot.toString());
			newRoot = newRoot.left;
		}
	}

	private MyNode convert_additionalDS(TreeNode<Integer> node) {

		MyNode myNode = new MyNode();

		if (node.left != null) {
			MyNode left = convert_additionalDS(node.left);
			node.left = left.max;
			left.max.right = node;
			myNode.min = left.min;
		} else
			myNode.min = node;

		if (node.right != null) {
			MyNode right = convert_additionalDS(node.right);
			node.right = right.min;
			right.min.left = node;
			myNode.max = right.max;
		} else {
			myNode.max = node;
		}

		return myNode;
	}

	private static class MyNode {

		TreeNode<Integer> max;
		TreeNode<Integer> min;
	}


}
