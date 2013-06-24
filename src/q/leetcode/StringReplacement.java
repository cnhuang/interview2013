package q.leetcode;

import org.testng.annotations.Test;

import util.Question;

public class StringReplacement extends Question {

	@Override
	public String getQuestion() {
		return "http://leetcode.com/2010/11/microsoft-string-replacement-problem.html";
	}

	@Test
	public void replace(String origin, String replace) {

		int index = 0;
		int matchCount = 0;
		int xCount = 0;

		for (int i = 0; i < origin.length(); i++) {

			Character c = origin.charAt(i);

			if (c == replace.charAt(matchCount)) {
				matchCount++;
			} else {
				index++;
				if (c == replace.charAt(0))
					matchCount = 1;
				else {
					matchCount = 0;
					if()
				}
			}

			if (matchCount == replace.length()) {
				xCount++;
			}

		}

	}

}
