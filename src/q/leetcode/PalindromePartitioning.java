package q.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import util.Question;

public class PalindromePartitioning extends Question {

	int iteration = 0;

	@Override
	public String getQuestion() {

		/**
		 * Given a string s, partition s such that every substring of the
		 * partition is a palindrome.
		 * 
		 * Return all possible palindrome partitioning of s.
		 * 
		 * For example, given s = "aab", Return
		 * 
		 * [ ["aa","b"], ["a","a","b"] ]
		 */

		return "http://leetcode.com/onlinejudge#question_131";
	}

	@Test
	public void partition() {

		String s = "ltsqjodzeriqdtyewsrpfscozbyrpidadvsmlylqrviuqiynbscgmhulkvdzdicgdwvquigoepiwxjlydogpxdahyfhdnljshgjeprsvgctgnfgqtnfsqizonirdtcvblehcwbzedsmrxtjsipkyxk";

		List<List<String>> result = new LinkedList<List<String>>();

		iteration = 0;
		partition_recursive(s, new LinkedList<String>(), result);

		Log(iteration);
		Log(result);
		Log(result.size());

	}

	private void partition_recursive(String s, List<String> path,
			List<List<String>> result) {

		if (s.length() == 0) {
			result.add(path);
			return;
		}

		if (s.length() == 1) {
			path.add(s);
			result.add(path);
			return;
		}

		for (int i = 1; i <= s.length(); i++) {

			iteration++;
			String subString = s.substring(0, i);

			if (isPalindrome(subString)) {

				List<String> clone = clone(path);
				clone.add(subString);
				partition_recursive(s.substring(i), clone, result);
			}

		}
	}

	@Test
	public void partition2() {

		String s = "ltsqjodzeriqdtyewsrpfscozbyrpidadvsmlylqrviuqiynbscgmhulkvdzdicgdwvquigoepiwxjlydogpxdahyfhdnljshgjeprsvgctgnfgqtnfsqizonirdtcvblehcwbzedsmrxtjsipkyxk";

		Map<String, List<List<String>>> cache = new HashMap<String, List<List<String>>>();

		iteration = 0;
		List<List<String>> result = partition_recursive_efficient(s, cache);

		Log(iteration);
		Log(result);
		Log(result.size());

		int min = Integer.MAX_VALUE;

		for (List<String> list : result) {
			if (min > list.size())
				min = list.size();
		}

		Log(min - 1);

	}

	@SuppressWarnings("unchecked")
	private List<List<String>> partition_recursive_efficient(String s,
			Map<String, List<List<String>>> cache) {

		List<List<String>> result = new LinkedList<List<String>>();

		if (s.length() == 0) {
			result.add(new LinkedList<String>());
			return result;
		}

	
		if (cache.containsKey(s))
			return cache.get(s);

		for (int i = 1; i <= s.length(); i++) {

			iteration++;

			String subString = s.substring(0, i);

			if (isPalindrome(subString)) {

				List<List<String>> tmp = partition_recursive_efficient(s.substring(i),
						cache);

				for (List<String> list : tmp) {

					List<String> clone = (List<String>) ((LinkedList<String>) list)
							.clone();
					clone.add(0, subString);
					result.add(clone);
				}
			}
		}

		cache.put(s, result);
		return result;
	}

	private boolean isPalindrome(String s) {

		if (s == null || s.length() <= 1)
			return true;

		for (int i = 0; i < s.length() / 2; i++)
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		return true;
	}

	private List<String> clone(List<String> input) {

		if (input == null)
			return null;

		List<String> result = new LinkedList<String>();

		for (String str : input)
			result.add(str);

		return result;

	}
}
