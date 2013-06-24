package ds;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import org.testng.annotations.Test;

public class TreeNode<T> {

	public boolean visited = false;
	public TreeNode<T> left;
	public TreeNode<T> right;
	public TreeNode<T> parent;
	public T data;

	public TreeNode(T data) {
		this.data = data;
	}

	public TreeNode() {
	}

	public String print() {
		return print(true);
	}

	public String print(boolean indent) {

		String indentStr = indent ? " " : "";

		StringBuffer sb = new StringBuffer();
		sb.append("\n\n");
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
					sb.append(indentStr);
				}
				sb.append(str);

				for (int i = 0; i < (maxString - str.length() - nodeLeftMargin); i++)
					sb.append(indentStr);
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

	public static TreeNode<Integer> getRandomTree(int size) {

		return getRandomTree(new boolean[size], 0, size);
	}

	private static TreeNode<Integer> getRandomTree(boolean[] cache, int start,
			int end) {

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

		n.left = getRandomTree(cache, start, end);
		n.right = getRandomTree(cache, start, end);

		return n;
	}

	public static TreeNode<Integer> getBinarySearchTree() {
		return getBinarySearchTree(new boolean[50], 0, 50);
	}

	public static TreeNode<Integer> getBinarySearchTree(boolean[] cache,
			int start, int end) {

		if (end <= start)
			return null;

		Integer data = null;

		for (int i = 0; i < 10; i++) {
			int index = random.nextInt(end - start + 1);
			if (!cache[index]) {
				cache[index] = true;
				data = index + start;
				break;
			}
		}

		if (data == null)
			return null;

		System.out
				.println("Start: " + start + ",End:" + end + ", Data:" + data);

		TreeNode<Integer> n = new TreeNode<Integer>(data);
		n.left = getBinarySearchTree(cache, start, data - 1);
		n.right = getBinarySearchTree(cache, data + 1, end);

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

	public static TreeNode<Integer> getSimpleTree(int size) {

		return getSimpleTree(0, size - 1);

	}

	private static TreeNode<Integer> getSimpleTree(int s, int e) {

		if (s > e)
			return null;

		int middle = (s + e) / 2;

		TreeNode<Integer> node = new TreeNode<Integer>();
		node.data = middle;

		node.left = getSimpleTree(s, middle - 1);
		node.right = getSimpleTree(middle + 1, e);

		return node;
	}

	@Test
	public void testPrint() {
		System.out.println(getRandomTree().print());
	}
}
