package q.leetcode;

import org.testng.annotations.Test;

import util.Question;

public class MultiplyString extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given two numbers represented as strings, return multiplication of
		 * the numbers as a string.
		 * 
		 * Note: The numbers can be arbitrarily large and are non-negative.
		 */
		return "http://leetcode.com/onlinejudge#question_43";
	}

	@Test
	public void test() {
		multiply("123124", "789789");
	}

	public String multiply(String num1, String num2) {

		if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0)
			return "0";

		if (num1 == "0" || num2 == "0") {
			return "0";
		}

		if (num1 == "1")
			return num2;

		if (num2 == "1")
			return num1;

		String shortStr = num1;
		String longStr = num2;

		if (num1.length() > num2.length()) {
			shortStr = num2;
			longStr = num1;
		}

		String preStr = null;
		for (int i = shortStr.length() - 1; i >= 0; i--) {

			int carry = 0;
			int n1 = Integer.valueOf(String.valueOf(shortStr.charAt(i)));
			StringBuffer sb = new StringBuffer();

			for (int j = shortStr.length() - 1; j > i; j--) {
				sb.append("0");
			}

			for (int j = longStr.length() - 1; j >= 0; j--) {
				int n2 = Integer.valueOf(String.valueOf(longStr.charAt(j)));
				int sum = n1 * n2 + carry;
				int digit = sum % 10;
				// Log(n1 + "x" + n2 + "+" + carry);
				carry = sum / 10;
				sb.insert(0, digit);
			}

			if (carry != 0)
				sb.insert(0, carry);

			if (preStr == null)
				preStr = sb.toString();
			else {
				preStr = add(preStr, sb.toString());
			}
		}

		return "";
	}

	public String add(String num1, String num2) {

		int index1 = num1.length() - 1;
		int index2 = num2.length() - 1;

		int carry = 0;
		StringBuffer sb = new StringBuffer();
		while (index1 >= 0 || index2 >= 0 || carry > 0) {

			int n1 = 0;
			int n2 = 0;

			if (index1 >= 0)
				n1 = Integer.parseInt(String.valueOf(num1.charAt(index1)));

			if (index2 >= 0)
				n2 = Integer.parseInt(String.valueOf(num2.charAt(index2)));

			int sum = n1 + n2 + carry;
			int digit = sum % 10;
			carry = sum / 10;
			sb.insert(0, digit);
			
			index1--;
			index2--;
		}

		return sb.toString();

	}

}
