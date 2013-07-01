package q.leetcode;

import org.testng.annotations.Test;

import util.Question;

public class WildcardMatching extends Question {

	@Override
	public String getQuestion() {
		/*
		 * '?' Matches any single character. '*' Matches any sequence of
		 * characters (including the empty sequence).
		 * 
		 * The matching should cover the entire input string (not partial).
		 * 
		 * The function prototype should be: bool isMatch(const char *s, const
		 * char *p)
		 * 
		 * Some examples: isMatch("aa","a") ? false isMatch("aa","aa") ? true
		 * isMatch("aaa","aa") ? false isMatch("aa", "*") ? true isMatch("aa",
		 * "a*") ? true isMatch("ab", "?*") ? true isMatch("aab", "c*a*b") ?
		 * false
		 */
		return "http://leetcode.com/onlinejudge#question_44";
	}

	@Test
	public void test() {
		Log(isMatch_efficient("abbc", "ab*bc"));
	}

	public boolean isMatch(String s, String p) {
		return isMatch_inefficient(s, p);
	}

	public boolean isMatch_efficient(String s, String p) {

		if (s == null || s.length() == 0)
			return p == null || p.length() == 0 || p.equals("*");

		if (p == null || p.length() == 0)
			return s == null || s.length() == 0;

		int pIndex = 0;
		int sIndex = 0;
		Integer starIndex = null;
		Integer lastMatchIndex = null;

		while (sIndex < s.length()) {

			if (pIndex < p.length()) {

				if (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?') {
					pIndex++;
					sIndex++;
					continue;
				} else if (p.charAt(pIndex) == '*') {

					// last one is *
					if (pIndex == p.length() - 1)
						return true;

					lastMatchIndex = sIndex;
					starIndex = pIndex;
					pIndex++;
					continue;
				}
			}

			if (starIndex != null) {
				pIndex = starIndex + 1;
				sIndex = lastMatchIndex++;
			} else {
				return false;
			}
		}

		for (int i = pIndex; i < p.length(); i++)
			if (p.charAt(i) == '*')
				pIndex++;
			else
				break;

		return pIndex == p.length();

	}

	public boolean isMatch_inefficient(String s, String p) {

		if (s == null || s.length() == 0)
			return p == null || p.length() == 0 || p.equals("*");

		if (p == null || p.length() == 0)
			return s == null || s.length() == 0;

		int sIndex = 0;
		for (int i = 0; i < p.length(); i++) {

			if (sIndex >= s.length())
				return isMatch(null, p.substring(i));

			char c = p.charAt(i);

			if (c != '*') {
				if (!isMatch(s.charAt(sIndex), c))
					return false;

			} else {

				boolean match = false;

				for (int j = sIndex; j <= s.length(); j++) {
					match |= isMatch(s.substring(j), p.substring(i + 1));

				}

				return match;

			}

			sIndex++;
		}

		return sIndex == s.length();

	}

	public boolean isMatch(char a, char b) {

		if (a == b)
			return true;

		if (a == '?' || b == '?')
			return true;

		return false;

	}

}
