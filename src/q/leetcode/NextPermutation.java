package q.leetcode;

import java.util.Arrays;

import util.Question;

public class NextPermutation extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Implement next permutation, which rearranges numbers into the
		 * lexicographically next greater permutation of numbers.
		 * 
		 * If such arrangement is not possible, it must rearrange it as the
		 * lowest possible order (ie, sorted in ascending order).
		 * 
		 * The replacement must be in-place, do not allocate extra memory.
		 * 
		 * Here are some examples. Inputs are in the left-hand column and its
		 * corresponding outputs are in the right-hand column. 1,2,3 ¡÷ 1,3,2
		 * 3,2,1 ¡÷ 1,2,3 1,1,5 ¡÷ 1,5,1
		 */
		return "http://leetcode.com/onlinejudge#question_31";
	}

	public void nextPermutation(int[] num) {

		if (num == null || num.length < 2)
			return;

		for (int i = num.length - 2; i >= 0; i--) {

			// search from the end
			// find the min number which is larger than num[i]
			int minIndex = -1;
			for (int j = i + 1; j < num.length; j++) {
				if (num[j] > num[i] && (minIndex == -1 || num[j] < num[minIndex])) {
					minIndex = j;
				}
			}

			// if found, swap minIndex and i
			// sort all the number after i
			if (minIndex != -1) {
				int tmp = num[minIndex];
				num[minIndex] = num[i];
				num[i] = tmp;
				Arrays.sort(num, i + 1, num.length);
				return;
			}

		}

		Arrays.sort(num);

	}

}
