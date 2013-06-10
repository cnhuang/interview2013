package q.com.google;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ds.Node;

import util.Question;

public class AddLinkedListNumbers extends Question {

	@Override
	public String getQuestion() {
		// Given they are the same length
		return "http://www.careercup.com/question?id=18469665";
	}

	@Test(dataProvider="dataProvider")
	public void add(Node<Integer> num1, Node<Integer> num2) {

		Log("Input:" + num1.toString());
		Log("Input:" + num2.toString());

		Node<Integer> result = add_recursive(num1, num2);

		Log("Result:" + result.toString());

	}

	private Node<Integer> add_recursive(Node<Integer> num1, Node<Integer> num2) {

		if (num1 == null)
			return null;

		Node<Integer> preDigit = add_recursive(num1.next, num2.next);
		int carry = 0;

		if (preDigit != null) {
			carry = preDigit.data / 10;
			preDigit.data %= 10;
		}

		Node<Integer> digit = new Node<Integer>(carry + num1.data + num2.data);
		digit.next = preDigit;

		return digit;
	}

	@DataProvider
	public static Object[][] dataProvider() {

		return new Object[][] { { toNode(31258), toNode(94679) } };
	}

	public static Node<Integer> toNode(Integer num) {

		char[] chars = String.valueOf(num).toCharArray();

		Node<Integer> root = new Node<Integer>(Integer.valueOf(String.valueOf(chars[0])));
		Node<Integer> current = root;

		for (int i = 1; i < chars.length; i++) {
			Node<Integer> node = new Node<Integer>(Integer.valueOf(String.valueOf(chars[i])));
			current.next = node;
			current = node;
		}

		return root;

	}

}
