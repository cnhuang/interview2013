package q.leetcode;

import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.Test;

import util.Question;

public class PermutationSequence extends Question {

	@Override
	public String getQuestion() {
		/*
		 * The set [1,2,3,¡K,n] contains a total of n! unique permutations.
		 * 
		 * By listing and labeling all of the permutations in order, We get the
		 * following sequence (ie, for n = 3):
		 * 
		 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth
		 * permutation sequence.
		 * 
		 * Note: Given n will be between 1 and 9 inclusive.
		 */
		return "http://leetcode.com/onlinejudge#question_60";
	}

	@Test
	public void test() {
		Log(getPermutation(3, 5));
	}

	public String getPermutation(int n, int k) {

		int divisor = 1;
		int N = n - 1;

		k = k - 1;

		for (int i = 1; i < n; i++) {
			divisor *= i;
		}

		List<Integer> nums = new LinkedList<Integer>();

		for (int i = 1; i <= n; i++) {
			nums.add(i);
		}

		String s = "";

		while (N > 0) {

			Log("All:" + divisor);
			int index = (k / divisor);
			k = k % divisor;
			divisor /= (N--);
			s += nums.remove(index);
			Log(s);
		}

		for (Integer i : nums)
			s += i;

		return s;
	}
}
