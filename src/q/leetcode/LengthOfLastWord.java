package q.leetcode;

import util.Question;

public class LengthOfLastWord extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a string s consists of upper/lower-case alphabets and empty
		 * space characters ' ', return the length of last word in the string.
		 * 
		 * If the last word does not exist, return 0.
		 * 
		 * Note: A word is defined as a character sequence consists of non-space
		 * characters only.
		 * 
		 * For example, Given s = "Hello World", return 5.
		 */
		return "http://leetcode.com/onlinejudge#question_58";
	}

	public int lengthOfLastWord(String s) {

		if (s == null || s.length() == 0)
			return 0;

		int spaceBeforeLastWord = -1;
		int endOfLastWord = -1;

		for (int i = s.length() - 1; i >= 0; i--) {

			if (s.charAt(i) == ' ') {

				if (endOfLastWord != -1) {
					spaceBeforeLastWord = i;
					break;
				}

			} else {

				if (endOfLastWord == -1)
					endOfLastWord = i;
			}
		}
		return endOfLastWord - spaceBeforeLastWord;
	}
}
