package q.tree;

import java.util.Stack;

import org.testng.annotations.Test;

import ds.TreeNode;

import util.Question;

public class BSTToDoubleLinkedList extends Question {

	@Override
	public String getQuestion() {
		return "BST To Double Linked List With Inorder traversal";
	}

	@Test
	public void convert() {
		
		TreeNode<Integer> root = TreeNode.getBinarySearchTree();
		Log(DFS.iterative_InOrder(root));

		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
		stack.add(root);

		TreeNode<Integer> parent = null;
		TreeNode<Integer> head = null;

		while (!stack.isEmpty()) {

			TreeNode<Integer> node = stack.peek();

			if (node.left != null && !node.left.visited) {
				stack.push(node.left);
			} else if (!node.visited) {
				
				node.left = parent;
				if(parent != null)
					parent.right = node;
				
				if(head == null)
					head = node;
				
				node.visited = true;
				parent = node;
				
			} else if (node.right != null && !node.right.visited) {
				stack.push(node.right);
			} else{
				stack.pop();
			}
		}
		
		
		Log(head);
		while(head.right != null){
			head = head.right;
			Log(head);
		}
		
		Log("\n"+head);
		while(head.left != null){
			head = head.left;
			Log(head);
		}
	}

}
