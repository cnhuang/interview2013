package q;

import java.util.Arrays;

import org.testng.annotations.Test;

import util.Question;

public class RegularExpMatching extends Question {

	@Override
	public String getQuestion() {
		return "http://leetcode.com/onlinejudge#question_10";
	}

	@Test
	public void match() {
		Log(isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*a*a*b"));
		Log(isMatch2("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*a*a*b"));
	}

	public boolean isMatch2(String s, String p) {

		int m = s.length() + 1;
		int n = p.length() + 1;
		boolean[][] result = new boolean[n][m];

		result[0][0] = true;
		for (int i = 1; i < n; i++) {
			result[i][0] = p.charAt(i - 1) == '*' ? result[i - 2][0] : false;
		}
		for (int j = 1; j < m; j++) {
			result[0][j] = s.charAt(j - 1) == '*' ? result[0][j - 2] : false;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (p.charAt(i - 1) == '*')
					result[i][j] = match(s.charAt(j - 1), p.charAt(i - 2)) ?
							
							//either take previous result (so aaA will mathc a* but abA won't, since A take b's result)
							// or ignore * and previous char (take (i-2,j)
							(result[i][j - 1] || result[i - 2][j])
							
							// must ignore * and previous char
							: result[i - 2][j];
				else
					result[i][j] = match(s.charAt(j - 1), p.charAt(i - 1)) ?
							
							//if previous one match it will match
							result[i - 1][j - 1]
									
							//not match
							: false;
			}
		}

		s = "  " + s;
		Log(Arrays.toString(s.toCharArray()));

		for (int i = 0; i < n; i++) {

			char[] cs = new char[m + 1];
			if (i == 0)
				cs[0] = ' ';
			else
				cs[0] = p.charAt(i - 1);
			for (int j = 1; j <= m; j++)
				if (result[i][j - 1])
					cs[j] = 'O';
				else
					cs[j] = 'X';

			Log(Arrays.toString(cs));
		}

		return result[n - 1][m - 1];
	}

	boolean match(char a, char b) {
		if (a == '.' || b == '.')
			return true;
		else
			return a == b;
	}

	public boolean isMatch(String s, String p) {

		if (s == null || s.length() == 0)
			// important
			return p == null || p.length() == 0 || (p.length() == 2 && p.charAt(1) == '*');

		int sIndex = 0;

		for (int i = 0; i < p.length(); i++) {

			// important
			if (sIndex >= s.length())
				return isMatch(null, p.substring(i));

			boolean nextStar = i < p.length() - 1 && p.charAt(i + 1) == '*';

			char pChar = p.charAt(i);
			char sChar = s.charAt(sIndex);

			if (!nextStar) {
				if (!isMatch(sChar, pChar))
					return false;
				sIndex++;
			} else {

				boolean pass = false;

				pass |= isMatch(s.substring(sIndex), p.substring(i + 2));

				for (int j = sIndex; j < s.length(); j++) {

					if (isMatch(pChar, s.charAt(j))) {
						pass |= isMatch(s.substring(j + 1), p.substring(i + 2));

					} else
						break;
				}

				return pass;

			}
		}

		return sIndex == s.length();
	}

	public boolean isMatch(char a, char b) {

		if (a == b)
			return true;

		if (a == '.' || b == '.') {
			return true;
		}

		return false;
	}
}
