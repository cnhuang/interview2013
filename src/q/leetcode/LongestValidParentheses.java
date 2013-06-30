package q.leetcode;

import java.util.Stack;

import org.testng.annotations.Test;

import util.Question;

public class LongestValidParentheses extends Question {

	@Override
	public String getQuestion() {

		/*
		 * Given a string containing just the characters '(' and ')', find the
		 * length of the longest valid (well-formed) parentheses substring.
		 * 
		 * For "(()", the longest valid parentheses substring is "()", which has
		 * length = 2.
		 * 
		 * Another example is ")()())", where the longest valid parentheses
		 * substring is "()()", which has length = 4.
		 */
		return "http://leetcode.com/onlinejudge#question_32";
	}

	@Test
	public void test() {
		longestValidParentheses("()");
	}

	public int longestValidParentheses(String s) {

		if (s == null || s.length() < 2)
			return 0;

		Stack<W> stack = new Stack<W>();
		int maxCount = 0;

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);
			W w = new W(i,c);
			
			if (c == '(')
				stack.push(w);
			else {
				if (!stack.empty() && stack.peek().c == '(') {
					stack.pop();
					maxCount = Math.max(i - (stack.empty() ? -1 : stack.peek().index), maxCount);
				} else
					stack.push(w);
			}

		}

		Log(", max:" + maxCount );

		return maxCount;
	}

	private static class W {

		int index;
		char c;

		public W(int index, char c) {
			this.index = index;
			this.c = c;
		}
	}
}
