package q.leetcode;

import java.util.Arrays;

import org.testng.annotations.Test;

import util.Question;

public class DistinctSubsequences extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a string S and a string T, count the number of distinct
		 * subsequences of T in S.
		 * 
		 * A subsequence of a string is a new string which is formed from the
		 * original string by deleting some (can be none) of the characters
		 * without disturbing the relative positions of the remaining
		 * characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is
		 * not).
		 * 
		 * Here is an example: S = "rabbbit", T = "rabbit"
		 * 
		 * Return 3.
		 */
		return "http://leetcode.com/onlinejudge#question_115";
	}

	@Test
	public void test() {

		String S = "ccc", T = "c";
		Log(numDistinct_recursive(S, T));
		Log(numDistinct_efficient(S, T));
		Log(numDistinct_efficient2(S, T));
		Log(numDistinct_efficient_from_recursive(S, T));
	}

	public int numDistinct_recursive(String S, String T) {

		if (S.length() == 0 || T.length() == 0)
			return 0;

		return numDistinct_recursive(S, T, 0, 0);

	}

	public int numDistinct_recursive(String S, String T, int s1, int s2) {

		if (T.length() - s2 > S.length() - s1)
			return 0;

		if (s2 == T.length())
			return 1;

		if (S.charAt(s1) != T.charAt(s2))
			return numDistinct_recursive(S, T, s1 + 1, s2);

		return numDistinct_recursive(S, T, s1 + 1, s2 + 1)
				+ numDistinct_recursive(S, T, s1 + 1, s2);

	}

	public int numDistinct_efficient_from_recursive(String S, String T) {

		if (S.length() == 0 || T.length() == 0)
			return 0;

		if (S.length() < T.length())
			return 0;

		int[][] match = new int[S.length() + 1][T.length() + 1];
		match[S.length()][T.length()] = 1;
		for (int i = 0; i < S.length(); i++)
			match[i][T.length()] = 1;

		for (int j = T.length() - 1; j >= 0; j--) {
			for (int i = S.length() - 1; i >= 0; i--) {
				if (S.charAt(i) == T.charAt(j)) {
					match[i][j] = match[i + 1][j + 1] + match[i + 1][j];

				} else {
					match[i][j] = match[i + 1][j];
				}
			}
		}

		for (int i = 0; i <= S.length(); i++) {
			Log(Arrays.toString(match[i]));
		}

		return match[0][0];

	}

	public int numDistinct_efficient(String S, String T) {

		int[] match = new int[T.length() + 1];

		if (S.length() == 0 || T.length() == 0)
			return 0;

		if (S.length() < T.length())
			return 0;

		match[0] = 1;

		for (int i = 1; i <= T.length(); i++)
			match[i] = 0;

		for (int i = 1; i <= S.length(); i++) {

			Log("Before " + S.charAt(i - 1) + ":" + Arrays.toString(match));

			for (int j = T.length(); j >= 1; j--) {

				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					match[j] += match[j - 1];
				}
			}

			// Log("After " + S.charAt(i - 1) + ":" + Arrays.toString(match));
		}
		return match[T.length()];

	}

	public int numDistinct_efficient2(String S, String T) {

		if (S.length() == 0 || T.length() == 0)
			return 0;

		if (S.length() < T.length())
			return 0;

		int[][] match = new int[S.length() + 1][T.length() + 1];
		match[0][0] = 1;
		for (int i = 0; i <= S.length(); i++)
			match[i][0] = 1;

		for (int j = 1; j <= T.length(); j++) {
			for (int i = 1; i <= S.length(); i++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					match[i][j] = match[i - 1][j - 1] + match[i - 1][j];

				} else {
					match[i][j] = match[i - 1][j];
				}
			}
		}

		for (int i = 0; i <= S.length(); i++) {
			Log(Arrays.toString(match[i]));
		}

		return match[S.length()][T.length()];

	}
}
