package q.leetcode;

import org.testng.annotations.Test;

import util.Question;

public class LongestCommonPrefix extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Write a function to find the longest common prefix string amongst an
		 * array of strings.
		 */
		return "http://leetcode.com/onlinejudge#question_14";
	}

	@Test
	public void find(String[] strs) {

		String ans = "";
		StringBuffer sb = new StringBuffer();

		if (strs != null && strs.length > 0) {

			int index = 0;
			boolean stop = false;

			while (!stop) {

				Character c = null;

				for (String str : strs) {

					if (str.length() == index) {
						stop = true;
						break;
					}

					if (c == null) {
						c = str.charAt(index);
					} else if (c != str.charAt(index)) {
						stop = true;
						break;
					}
				}

				if (!stop)
					sb.append(c);

				index++;
			}
		}

		ans = sb.toString();
		Log(ans);

	}

}
