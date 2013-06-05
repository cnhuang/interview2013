package q;

import ds.TreeNode;

public class FirstCommonAncestor {

	// write a DFS function to return path of each node
	// then compare path

	public static void main(String[] args) {
		
		TreeNode<Integer> t = TreeNode.getBinarySearchTree(new boolean[10], 0, 10);

		System.out.println(Find(t, new TreeNode<Integer>(0), new TreeNode<Integer>(10)).data);
		System.out.println(Find(t, new TreeNode<Integer>(1), new TreeNode<Integer>(2)).data);
		System.out.println(Find(t, new TreeNode<Integer>(1), new TreeNode<Integer>(3)).data);
		System.out.println(Find(t, new TreeNode<Integer>(4), new TreeNode<Integer>(3)).data);
		System.out.println(Find(t, new TreeNode<Integer>(5), new TreeNode<Integer>(3)).data);
	}

	public static TreeNode<Integer> Find(TreeNode<Integer> tree, TreeNode<Integer> n1,
			TreeNode<Integer> n2) {
		if (tree == null)
			return null;

		if (tree.data == n1.data || tree.data == n2.data) {
			return tree;
		}

		boolean n1OnRight = IsCover(tree.right, n1);
		boolean n2OnRight = IsCover(tree.right, n2);

		if (n1OnRight == n2OnRight)
			return n1OnRight ? Find(tree.right, n1, n2) : Find(tree.left, n1, n2);
		else {
			return tree;
		}
	}

	private static boolean IsCover(TreeNode<Integer> tree, TreeNode<Integer> n) {
		if (tree == null)
			return false;

		if (tree.data == n.data)
			return true;

		return IsCover(tree.left, n) || IsCover(tree.right, n);
	}

}
