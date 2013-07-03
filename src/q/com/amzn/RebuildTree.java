package q.com.amzn;

import org.testng.annotations.Test;

import util.Question;
import util.Wrapper;

public class RebuildTree extends Question {

	@Override
	public String getQuestion() {

		return "Given a special tree which has 2 kinds of node: P contains 5 L and L the leaf node."
				+ " Write a method to rebuild the tree from its preorder."
				+ " Folloow up, if we want to verify if the input is a valid tree, how?";
	}

	@Test
	public void rebuild() {

		Wrapper<Integer> index = new Wrapper<Integer>(0);
		rebuild("PLPLLLLLLLPLLPLLLLLLL", index);

	}

	@Test
	public void verify() {

		Wrapper<Integer> index = new Wrapper<Integer>(0);
		String s = "PLPLLLLLLLPLLPLLLLLLL";
		rebuild(s, index);

		if (index.obj.intValue() != s.length()-1)
			throw new RuntimeException("Invalid string, too short.");
	}

	public Node rebuild(String s, Wrapper<Integer> index) {

		if (index.obj == s.length())
			throw new RuntimeException("Invalid string, too long.");

		char c = s.charAt(index.obj);

		Node node;
		if (c == 'P') {

			node = new Node(Type.P);

			for (int i = 0; i < 5; i++) {
				index.obj++;
				node.children[i] = rebuild(s, index);
			}
		} else {

			node = new Node(Type.L);
		}

		return node;
	}

	public enum Type {
		P, L;
	}

	public class Node {
		Type type;
		Node[] children;

		public Node(Type p) {
			type = p;

			if (p.equals(Type.P))
				children = new Node[5];
		}
	}

}
