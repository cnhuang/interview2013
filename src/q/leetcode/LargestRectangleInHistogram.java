package q.leetcode;

import java.util.Arrays;
import java.util.Stack;

import org.testng.annotations.Test;

import util.Question;

public class LargestRectangleInHistogram extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given n non-negative integers representing the histogram's bar height
		 * where the width of each bar is 1, find the area of largest rectangle
		 * in the histogram.
		 * 
		 * Above is a histogram where width of each bar is 1, given height =
		 * [2,1,5,6,2,3].
		 * 
		 * The largest rectangle is shown in the shaded area, which has area =
		 * 10 unit.
		 * 
		 * For example, Given height = [2,1,5,6,2,3], return 10.
		 */
		return "http://leetcode.com/onlinejudge#question_84";
	}

	@Test
	public void test() {
		int[] height = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 2147483647 };
		largestRectangleArea(height);
	}

	public int largestRectangleArea(int[] height) {

		if (height == null || height.length == 0) {
			return 0;
		}

		int[] area = new int[height.length];
		Arrays.fill(area, 1);

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < height.length; i++) {

			while (!stack.isEmpty()) {

				int peek = stack.peek();
				if (height[peek] >= height[i]) {
					stack.pop();
				} else {
					break;
				}
			}

			if (stack.empty()) {
				area[i] += i;
			} else {
				area[i] += i - stack.peek() - 1;
			}

			stack.push(i);
		}

		Log(Arrays.toString(area));

		stack = new Stack<Integer>();

		for (int i = height.length - 1; i >= 0; i--) {

			while (!stack.isEmpty()) {

				int peek = stack.peek();
				if (height[peek] >= height[i]) {
					stack.pop();
				} else {
					break;
				}
			}

			if (stack.empty()) {
				area[i] += (height.length - 1 - i);
			} else {
				area[i] += stack.peek() - i - 1;
			}

			stack.push(i);
		}

		int max = 0;

		for (int i = 0; i < area.length; i++) {
			max = Math.max(max, area[i] * height[i]);
		}

		Log(Arrays.toString(area));

		return max;
	}

}
