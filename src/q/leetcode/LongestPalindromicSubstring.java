package q.leetcode;

import org.testng.annotations.Test;

import util.Question;

public class LongestPalindromicSubstring extends Question {

	@Override
	public String getQuestion() {
		return "http://leetcode.com/2011/11/longest-palindromic-substring-part-i.html";
	}

	@Test
	public void find_bruteForce() {
		// Search all the possible strings
		// e.g. (0,N), (0,N-1)... (1, N) (1, N-1) -> N^3
	}
	
	@Test
	public void find_mostEfficient(){
		//http://www.felix021.com/blog/read.php?2040
	}

	@Test
	public void find_efficient() {

		// Start from all possible 2N-1 start point. look left and right;
		// N^2

		String[] strs = { "abacdfgdcaba", "abacdgfdcaba", "bb" };

		for (String s : strs) {

			Log(s);
			String maxString = "";
			for (int i = 0; i < 2 * s.length() - 1; i++) {

				int leftStart = i / 2;
				int rightStart = i / 2;

				if (i % 2 == 1) {
					rightStart += 1;
				}

				while (leftStart >= 0 && rightStart < s.length()) {

					if (s.charAt(leftStart) == s.charAt(rightStart)) {

						if (rightStart - leftStart + 1 > maxString.length()) {
							maxString = s.substring(leftStart, rightStart + 1);
						}

						leftStart--;
						rightStart++;
					} else {
						break;
					}
				}
			}

			Log(maxString);
		}
	}
}
