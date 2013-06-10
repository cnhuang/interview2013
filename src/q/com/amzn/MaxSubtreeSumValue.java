package q.com.amzn;

import java.util.Hashtable;

import ds.TreeNode;

public class MaxSubtreeSumValue {

	public static void main(String[] args) {
		TreeNode<Integer> t = TreeNode.getRandomTree();
		TreeNode<Integer> r = FindMaxSubtree(t,
				new Hashtable<TreeNode<Integer>, Integer>());
		System.out.println(r.data);
	}

	public static TreeNode<Integer> FindMaxSubtree(TreeNode<Integer> node,
			Hashtable<TreeNode<Integer>, Integer> sum) {
		if (node == null)
			return null;

		TreeNode<Integer> leftMaxNode = FindMaxSubtree(node.left, sum);
		TreeNode<Integer> rightMaxNode = FindMaxSubtree(node.right, sum);

		int nodeSum = node.data + (node.left == null ? 0 : sum.get(node.left))
				+ (node.right == null ? 0 : sum.get(node.right));
		sum.put(node, nodeSum);

		TreeNode<Integer> maxNode = node;
		int max = nodeSum;

		if (leftMaxNode != null && sum.get(leftMaxNode) > max) {
			maxNode = leftMaxNode;
			max = sum.get(leftMaxNode);
		}

		if (rightMaxNode != null && sum.get(rightMaxNode) > max) {
			maxNode = rightMaxNode;
			max = sum.get(rightMaxNode);
		}

		return maxNode;
	}

}
