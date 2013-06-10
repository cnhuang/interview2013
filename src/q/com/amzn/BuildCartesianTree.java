package q.com.amzn;

import org.testng.annotations.Test;

import ds.TreeNode;
import util.Question;

public class BuildCartesianTree extends Question {

	@Override
	public String getQuestion() {
		return "http://en.wikipedia.org/wiki/Cartesian_tree#Efficient_construction";
	}

	@Test
	public void build() {

		int[] arr = { 9, 3, 7, 1, 8, 12, 10, 20, 15, 18, 5 };

		TreeNode<Integer> previous = new TreeNode<Integer>(arr[0]);

		for (int i = 1; i < arr.length; i++) {

			Log("\ncurrent:" + arr[i]);

			TreeNode<Integer> current = new TreeNode<Integer>(arr[i]);
			TreeNode<Integer> target = previous;

			// find highest target which is smaller than current or non-null
			while (target.data > current.data && target.parent != null) {
				target = target.parent;
			}

			Log("target:" + target.data);

			// smaller target is found
			// current will be in target's right
			if (current.data > target.data) {

				Log("add " + current.data + " to " + target.data + "'s right");

				// target's right exist. move target's right to current's left
				if (target.right != null) {

					Log("move " + target.right.data + " to " + current.data
							+ "'s left");
					current.left = target.right;
					target.right.parent = current;
				}

				target.right = current;
				current.parent = target;

			} else {

				// no smaller target is found. Current will be on top
				Log("add " + target.data + " to " + current.data + "'s left");

				current.left = target;
				target.parent = current;
			}

			previous = current;
		}

		TreeNode<Integer> root = previous;

		while (root.parent != null)
			root = root.parent;

		Log(root.print());

	}
}
