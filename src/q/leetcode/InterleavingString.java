package q.leetcode;

import org.testng.annotations.Test;

import util.Question;

public class InterleavingString extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1
		 * and s2.
		 * 
		 * For example, Given: s1 = "aabcc", s2 = "dbbca",
		 * 
		 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return
		 * false.
		 */
		return "http://leetcode.com/onlinejudge#question_97";
	}

	@Test
	public void test() {
		Log(isInterleave("aacaac", "aacaaeaac", "aacaaeaaeaacaac"));
	}

	public boolean isInterleave_efficient(String s1, String s2, String s3) {
		if (s3.length() != s1.length() + s2.length())
			return false;

		boolean[][] match = new boolean[s1.length() + 1][s2.length() + 1];
		match[0][0] = true;

		int i = 1;
		while (i <= s1.length() && s1.charAt(i - 1) == s3.charAt(i - 1)) {
			match[i][0] = true;
			i++;
		}

		i = 1;
		while (i <= s2.length() && s2.charAt(i - 1) == s3.charAt(i - 1)) {
			match[0][i] = true;
			i++;
		}

		for (i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {

				// starts from s3.1, s3.0 is compared before.
				char c = s3.charAt(i + j - 1);
				if (c == s1.charAt(i - 1))
					match[i][j] = match[i - 1][j];
				if (c == s2.charAt(j - 1))
					match[i][j] = match[i][j - 1] || match[i][j];
			}
		}
		return match[s1.length()][s2.length()];

	}

	public boolean isInterleave(String s1, String s2, String s3) {

		if (s1 == "")
			return s2.equals(s3);

		if (s2 == "")
			return s1.equals(s3);

		if (s1.length() + s2.length() != s3.length())
			return false;

		return isInterleave(s1.toCharArray(), s2.toCharArray(),
				s3.toCharArray(), 0, 0, 0);
	}

	public boolean isInterleave(char[] s1, char[] s2, char[] s3, int s1Ind,
			int s2Ind, int s3Ind) {

		Log(s1Ind + "," + s2Ind + "," + s3Ind);

		while (s3Ind < s3.length) {

			if (s1Ind == s1.length) {
				if (s2[s2Ind++] != s3[s3Ind++]) {
					return false;
				}
			} else if (s2Ind == s2.length) {
				if (s1[s1Ind++] != s3[s3Ind++]) {
					return false;
				}
			} else {

				if (s1[s1Ind] != s2[s2Ind]) {
					if (s1[s1Ind] == s3[s3Ind]) {
						s1Ind++;
						s3Ind++;
					} else if (s2[s2Ind] == s3[s3Ind]) {
						s2Ind++;
						s3Ind++;
					} else {
						return false;
					}
				} else {

					if (s1[s1Ind] != s3[s3Ind])
						return false;

					if (isInterleave(s1, s2, s3, s1Ind + 1, s2Ind, s3Ind + 1)) {
						return true;
					}

					return isInterleave(s1, s2, s3, s1Ind, s2Ind + 1, s3Ind + 1);
				}

			}
		}

		return true;

	}

}
