package q.algo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class Palindrome_LinkedListString extends Question {

	@Override
	public String getQuestion() {
		return "http://www.careercup.com/question?id=17991681";
	}

	@Test(dataProvider = "dataProvider")
	public void isPalindrome_reverseList2(Node n, String str) {

		Log("Input2:" + n);

		Node curr = n;
		Node pre = null;

		while (curr != null) {
			Node next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}

		Log("Result:" + pre.toString());
	}

	@Test(dataProvider = "dataProvider")
	public void isPalindrome_recursive2(Node n, String str) {

		Log("[isPalindrome_recursive2] Input2:" + n);

		int length = 0;
		Node curr = n;

		while (curr != null) {
			length++;
			curr = curr.next;
		}

		Result r = isPalindrome_recursive2(n, 0, length - 1);
		Log("R:" + r.isPalindrome);

	}

	public Result isPalindrome_recursive2(Node n, int s, int e) {

		if (s == e)
			return new Result(true, n.next);
		else if (e - s == 1) {
			Node next = n.next;
			if (n.data == next.data)
				return new Result(true, next.next);
			else
				return new Result(false, null);
		} else {
			Result r = isPalindrome_recursive2(n.next, s + 1, e - 1);
			if (!r.isPalindrome || n.data != r.n.data)
				return r;
			else
				return new Result(true, r.n.next);
		}
	}

	public static class Result {
		boolean isPalindrome;
		Node n;

		public Result(boolean b, Node n) {
			this.isPalindrome = b;
			this.n = n;
		}
	}

	@Test(dataProvider = "dataProvider")
	public void isPalindrome_reverseList(Node n, String str) {

		Log("Input:" + str);
		if (str.length() == 1)
			Log(str + ":true");
		else {

			int middle = str.length() / 2;
			int currentIndex = 0;
			Node prev = null;
			Node current = n;
			Node next = null;

			while (currentIndex < middle) {

				next = current.next;
				current.next = prev;
				prev = current;
				current = next;

				currentIndex++;
			}

			Node firstHalf = prev;
			Node secondHalf = next;

			if (str.length() % 2 == 1) {
				secondHalf = secondHalf.next;
			}

			Log("FirstHalf is:" + firstHalf.data);
			Log("SecondHalf is:" + secondHalf.data);

			boolean failed = false;
			while (firstHalf != null) {

				Log("Compare:" + firstHalf.data + ", with " + secondHalf.data);

				if (firstHalf.data != secondHalf.data) {
					failed = true;
					break;
				} else {
					secondHalf = secondHalf.next;
					firstHalf = firstHalf.next;
				}
			}

			if (!failed && secondHalf != null) {
				Log("Second is not empty:" + secondHalf.data);
				failed = true;
			}

			Log(str + ":" + (!failed));

		}

	}

	@Test(dataProvider = "dataProvider")
	public void isPalindrome_recursive(Node n, String str) {

		if (str.length() == 1)
			Log(str + ":true");
		else if (isPalindrome_recursive(n, str.length(), 0) != null) {
			Log(str + ":true");
		} else {
			Log(str + ":false");
		}

	}

	private Node isPalindrome_recursive(Node n, int size, int index) {

		Node comparedNode = null;

		if ((size / 2) - 1 == index) {

			comparedNode = n.next;

			if (size % 2 == 1) {
				comparedNode = comparedNode.next;
			}
		} else {
			comparedNode = isPalindrome_recursive(n.next, size, index + 1);
			if (comparedNode != null)
				comparedNode = comparedNode.next;
		}

		if (comparedNode == null)
			return null;

		Log("compare:" + n.data + ", with " + comparedNode.data);

		if (n.data == comparedNode.data) {
			return comparedNode;
		}

		return null;

	}

	@DataProvider
	public static Object[][] dataProvider() {
		return new Object[][] { { Node.create("a"), "a" }, { Node.create("abcba"), "abcba" },
				{ Node.create("abba"), "abba" }, { Node.create("abdeba"), "abdeba" } };
	}

	private static class Node {
		char data;
		Node next;

		public static Node create(String str) {

			char[] chars = str.toCharArray();
			Node root = new Node();
			root.data = chars[0];
			Node current = root;

			for (int i = 1; i < chars.length; i++) {
				Node n = new Node();
				n.data = chars[i];
				current.next = n;
				current = n;
			}

			return root;
		}

		public String toString() {
			String s = "";
			s += data;
			if (next != null)
				s += next.toString();

			return s;
		}
	}

}
