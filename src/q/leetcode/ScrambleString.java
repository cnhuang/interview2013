package q.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import util.Question;

public class ScrambleString extends Question {

	@Override
	public String getQuestion() {
		/*
		 * http://n00tc0d3r.blogspot.com/2013/05/scramble-string.html
		 * 
		 * http://csjobinterview.wordpress.com/2012/05/07/google-scramble-string/
		 * 
		 * http://csjobinterview.wordpress.com/2012/06/29/google-scramble-string-
		 * ii-with-duplicated-characters/
		 * 
		 * http://csjobinterview.wordpress.com/2012/07/03/google-scramble-string-
		 * iii/
		 */
		return "http://leetcode.com/onlinejudge#question_87";
	}

	public boolean isScramble(String s1, String s2) {
		
		return isScramble(s1,s2,new HashMap<String,Boolean>());
	}

	public boolean isScramble(String s1, String s2, Map<String, Boolean> cache) {

		if (isEmpty(s1) && isEmpty(s2))
			return true;

		if (isEmpty(s1) != isEmpty(s2))
			return false;

		if (s1.length() != s2.length())
			return false;

		if (s1.equals(s2))
			return true;

		String key = s1 + "@" + s2;
		if (cache.containsKey(key))
			return cache.get(key);

		Boolean pass = false;
		for (int i = 1; i < s1.length(); i++) {

			String s1L = s1.substring(0, i);
			String s1R = s1.substring(i);

			String s2L1 = s2.substring(0, i);
			String s2R1 = s2.substring(i);

			String s2L2 = s2.substring(0, s2.length() - i);
			String s2R2 = s2.substring(s2.length() - i);

			if (isScramble(s1L, s2L1) && isScramble(s1R, s2R1)) {
				pass = true;
				break;
			}

			if (isScramble(s1L, s2R2) && isScramble(s1R, s2L2)) {
				pass = true;
				break;
			}

		}

		cache.put(key, pass);
		return pass;
	}

	public boolean isEmpty(String str) {
		return (str == null || str.length() == 0);
	}

}
