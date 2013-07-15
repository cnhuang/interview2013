package q;

import util.Question;

public class DiameterOfABinaryTree extends Question {

	@Override
	public String getQuestion() {
		/*
		 * The diameter of a tree (sometimes called the width) is the number of
		 * nodes on the longest path between two leaves in the tree. The diagram
		 * below shows two trees each with diameter nine, the leaves that form
		 * the ends of a longest path are shaded (note that there is more than
		 * one path in each tree of length nine, but no path longer than nine
		 * nodes).
		 */
		return "http://www.geeksforgeeks.org/diameter-of-a-binary-tree/";
	}

	public void diameter() {

		int lHeight = height(node.left);
		int rHeight = height(node.right);

		int lDiameter = diameter(node.left);
		int rDiameter = diameter(node.right);

		return Max(lHeight + rHeight + 1, lDiameter, rDiameter);

	}

}
