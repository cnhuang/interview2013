package ds.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import org.testng.annotations.Test;

public class TreeNode<T> {

	public boolean visited = false;
	public TreeNode<T> left;
	public TreeNode<T> right;
	public T data;

	public TreeNode(T data) {
		this.data = data;
	}

	public TreeNode() {
	}

	public String print() {

		StringBuffer sb = new StringBuffer();
		List<List<String>> lists = new LinkedList<List<String>>();
		int maxString = 0;

		List<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
		List<TreeNode<T>> queue2 = new LinkedList<TreeNode<T>>();
		queue.add(this);

		while (queue.size() > 0) {
			List<String> list = new LinkedList<String>();

			while (queue.size() > 0) {
				TreeNode<T> node = queue.remove(0);
				if (node.left != null)
					queue2.add(node.left);
				if (node.right != null)
					queue2.add(node.right);

				String str = String.valueOf(node.data);
				list.add(str);

				if (str.length() > maxString) {
					maxString = str.length();
				}
			}
			lists.add(list);
			queue = queue2;
			queue2 = new LinkedList<TreeNode<T>>();
		}

		int nodeSpace = maxString % 2 == 0 ? 2 : 1;
		for (int level = 0; level < lists.size(); level++) {

			List<String> list = lists.get(level);

			int levelDiff = lists.size() - 1 - level;
			int lineLeftSpace = (int) ((Math.pow(2, levelDiff) * maxString
					+ (Math.pow(2, levelDiff) - 1) * nodeSpace - maxString) / 2);

			for (int seq = 0; seq < list.size(); seq++) {

				int leftSpace = lineLeftSpace;
				if (seq > 0)
					leftSpace = 2 * lineLeftSpace + nodeSpace;

				String str = list.get(seq);
				int nodeLeftMargin = (maxString - str.length()) / 2;

				leftSpace += nodeLeftMargin;

				for (int i = 0; i < leftSpace; i++) {
					sb.append(" ");
				}
				sb.append(str);

				for (int i = 0; i < (maxString - str.length() - nodeLeftMargin); i++)
					sb.append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public String toString() {
		return String.valueOf(data);
	}

	private static Random random = new Random(System.currentTimeMillis());

	public static TreeNode<Integer> getRandomTree() {

		return getRandomTree(new boolean[50], 0, 50);
	}

	private static TreeNode<Integer> getRandomTree(boolean[] cache, int start, int end) {

		if (end <= start)
			return null;

		Integer data = null;

		for (int i = 0; i < 10; i++) {
			int index = random.nextInt(end - start);
			if (!cache[index]) {
				cache[index] = true;
				data = index + start;
				break;
			}
		}

		if (data == null)
			return null;

		TreeNode<Integer> n = new TreeNode<Integer>(data);
		n.left = getRandomTree(cache, start, (start + end) / 2);
		n.right = getRandomTree(cache, (start + end) / 2 + 1, end);

		return n;
	}

	public static TreeNode<?> cleanVisited(TreeNode<?> t) {

		Queue<TreeNode<?>> queue = new LinkedList<TreeNode<?>>();
		queue.add(t);

		while (queue.size() > 0) {

			TreeNode<?> node = queue.poll();
			node.visited = false;

			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}

		return t;
	}

	@Test
	public void testPrint() {
		System.out.println(getRandomTree().print());
	}
}
