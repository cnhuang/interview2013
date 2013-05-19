package question;

import org.testng.annotations.Test;

import ds.tree.TreeNode;

import util.Question;

public class BinarySerachTreeToDoubleLinkedList extends Question {

	@Override
	public String getQuestion() {

		return "Convert a binary search tree into a double linked list. Cracking code interview 17.13";
	}

	@Test
	public void find() {

		Log(TreeNode.getBinarySearchTree().print());
	}

}
