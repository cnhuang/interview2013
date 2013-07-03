package q.leetcode;

import util.Question;

public class EditDistance extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given two words word1 and word2, find the minimum number of steps
		 * required to convert word1 to word2. (each operation is counted as 1
		 * step.)
		 * 
		 * You have the following 3 operations permitted on a word:
		 * 
		 * a) Insert a character b) Delete a character c) Replace a character
		 */
		// http://fisherlei.blogspot.com/2012/12/leetcode-edit-distance.html
		return "http://leetcode.com/onlinejudge#question_72";
	}

	public int minDistance(String word1, String word2) {

		if (equal(word1, word2))
			return 0;

		if (isEmpty(word1) && !isEmpty(word2))
			return word2.length();

		if (isEmpty(word2) && !isEmpty(word1))
			return word1.length();

		int[][] d = new int[word1.length() + 1][word2.length() + 1];

		for (int i = 0; i <= word1.length(); i++) {
			d[i][0] = i;
		}

		for (int i = 0; i <= word2.length(); i++) {
			d[0][i] = i;
		}

		for (int i = 1; i < word1.length() + 1; i++) {
			for (int j = 1; j < word2.length() + 1; j++) {

				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					d[i][j] = d[i - 1][j - 1];
				} else {
					d[i][j] = Math.min(d[i - 1][j - 1], Math.min(d[i - 1][j], d[i][j - 1])) + 1;
				}

			}
		}

		return d[word1.length()][word2.length()];

	}

	private boolean isEmpty(String s) {
		return s == null || s.length() == 0;
	}

	private boolean equal(String s1, String s2) {

		boolean s1b = isEmpty(s1);
		boolean s2b = isEmpty(s2);

		if (s1b && s2b)
			return true;

		if (s1b != s2b) {
			return false;
		}

		return s1.equals(s2);

	}

}
