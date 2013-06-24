package q.leetcode;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class FindMinWindowInStrSContainsAllElemInStrT extends Question {

	@Override
	public String getQuestion() {
		return "http://leetcode.com/2010/11/finding-minimum-window-in-s-which.html";
	}

	@Test(dataProvider = "dataProvider")
	public void find(String s, String t) {

		Result r = new Result(t);

		for (int i = 0; i < s.length(); i++) {

			r.set(s.charAt(i), i);
		}

		Log(s.subSequence(r.minStart, r.minEnd + 1));

	}

	@DataProvider
	public static Object[][] dataProvider() {

		return new Object[][] { { "ADOBECODEBANC", "ABC" } };

	}

	public static class Result {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int size = 0;
		int minStart = 0;
		int minEnd = Integer.MAX_VALUE;

		public Result(String s) {

			for (char c : s.toCharArray()) {
				map.put(c, -1);
			}
		}

		public void set(char c, int index) {

			if (map.containsKey(c)) {
				if (map.get(c) == -1) {
					size++;
				}

				map.put(c, index);

				if (size == map.size()) {
					update();
				}
			}
		}

		public boolean found() {
			return size == map.size();
		}

		private void update() {

			int min = Integer.MAX_VALUE;
			int max = 0;

			for (Integer v : map.values()) {
				min = Math.min(min, v);
				max = Math.max(max, v);
			}

			if (max - min < minEnd - minStart) {

				minStart = min;
				minEnd = max;
			}

		}

	}

}
