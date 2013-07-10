package q.leetcode;

import java.util.HashMap;
import java.util.Map;

import util.Question;

public class DecodeWays extends Question {

	@Override
	public String getQuestion() {
		/*
		 * A message containing letters from A-Z is being encoded to numbers
		 * using the following mapping:
		 * 
		 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing
		 * digits, determine the total number of ways to decode it.
		 * 
		 * For example, Given encoded message "12", it could be decoded as "AB"
		 * (1 2) or "L" (12).
		 * 
		 * The number of ways decoding "12" is 2.
		 */
		return "http://leetcode.com/onlinejudge#question_91";
	}

	public int numDecodings(String s) {
		return numDecodings(s,new HashMap<String,Integer>());
	}
	
	public int numDecodings(String s, Map<String,Integer> cache){

		if (s == null || s == "")
			return 0;

		if(cache.containsKey(s))
			return cache.get(s);
		
		if (s.length() == 1)
			return isValid(s) ? 1 : 0;

		int ways = 0;

		for (int i = 1; i <= s.length(); i++) {

			String s1 = s.substring(0, i);

			if (isValid(s1)) {
				if (i == s.length())
					ways += 1;
				else
					ways += numDecodings(s.substring(i));
			} else {
				break;
			}
		}

		cache.put(s, ways);
		return ways;

	}

	public boolean isValid(String s) {

		return Integer.valueOf(s) <= 26 && Integer.valueOf(s) > 0;
	}

}
