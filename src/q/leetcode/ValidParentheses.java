package q.leetcode;

import java.util.Stack;

import util.Question;

public class ValidParentheses extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a string containing just the characters '(', ')', '{', '}', '['
		 * and ']', determine if the input string is valid.
		 * 
		 * The brackets must close in the correct order, "()" and "()[]{}" are
		 * all valid but "(]" and "([)]" are not.
		 */
		return "http://leetcode.com/onlinejudge#question_20";
	}

	public boolean isValid(String s) {

		if (s == null || s.length() == 0)
			return true;

		if (s.length() % 2 != 0)
			return false;

		Stack<Character> stack = new Stack<Character>();

		for (char c : s.toCharArray()) {

			if (c == '(' || c == '[' || c == '{')
				stack.add(c);
			else {

				// important
				if (stack.size() == 0)
					return false;

				char tmp = stack.pop();

				if (tmp == '(' && c == ')')
					continue;

				else if (tmp == '[' && c == ']')
					continue;

				else if (tmp == '{' && c == '}')
					continue;

				return false;
			}
		}

		// important
		return stack.size() == 0;
	}

}
