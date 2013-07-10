package q.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import util.Question;

public class RecoverBST extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Two elements of a binary search tree (BST) are swapped by mistake.
		 * 
		 * Recover the tree without changing its structure.
		 * 
		 * Note: A solution using O(n) space is pretty straight forward. Could
		 * you devise a constant space solution?
		 */
		//http://fisherlei.blogspot.com/2012/12/leetcode-recover-binary-search-tree.html
		
		???
		return "http://leetcode.com/onlinejudge#question_99";
	}

	public void recoverTree(TreeNode root) {
		
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		Integer last = null;
		Set<TreeNode> visited = new HashSet<TreeNode>();
		List<TreeNode> arr = new ArrayList<TreeNode>();
		
		while(stack.isEmpty()){
			
			TreeNode n = stack.peek();
			
			if(n.left != null && !visited.contains(n.left)){
				stack.push(n.left);
			}else if(!visited.contains(n)){
				
				if(last == null || last < n.val)
					last = n.val;
				else {
					arr.add(n);
				}
				
				visited.add(n);
				
			}else if(n.right != null && !visited.contains(n.right)){
				stack.push(n.right);
			}else{
				stack.pop();
			}
		}
		
		int tmp = arr.get(0).val;
		arr.get(0).val = arr.get(1).val;
		arr.get(1).val = tmp;

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
