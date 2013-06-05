package q.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ds.TreeNode;

import util.Question;

public class PrintTreeInLevels extends Question {

	@Override
	public String getQuestion() {
		return "Print tree in layers";
	}

	@Test(dataProvider = "dataProvider")
	public void print(TreeNode<Integer> node) {

		Log("\nInput:" + node.print(false) + "\n\n");

		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		queue.add(node);
		queue.add(null);

		String str = "";
		while (queue.size() != 0) {

			TreeNode<Integer> n = queue.poll();
			if (n != null) {
				str += n.data + ",";
				if (n.left != null)
					queue.add(n.left);
				if (n.right != null)
					queue.add(n.right);

				if (queue.peek() == null)
					queue.add(null);
			} else {
				Log(">> " + str);
				str = "";
			}
		}
	}

	@Test(dataProvider = "dataProvider")
	public void print_reverse(TreeNode<Integer> node) {

		Log("\nInput:" + node.print(false) + "\n\n");
		boolean reverse = false;

		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		queue.add(node);
		queue.add(null);

		List<Integer> data = new LinkedList<Integer>();
		while (queue.size() != 0) {

			TreeNode<Integer> n = queue.poll();
			if (n != null) {
				
				data.add(n.data);
				
				if (n.left != null)
					queue.add(n.left);
				if (n.right != null)
					queue.add(n.right);

				if (queue.peek() == null) {
					queue.add(null);
					
				}
			} else {
				
				if(reverse){
					Collections.reverse(data);
				}
				
				Log(">> " + data);
				data.clear();				
				reverse = !reverse;
			}
		}
	}

	@DataProvider
	public static Object[][] dataProvider() {
		return new Object[][] { { TreeNode.getBinarySearchTree() } };
	}

}
