package q.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import util.Question;

public class ThreeSum extends Question {

	@Override
	public String getQuestion() {
		return "http://leetcode.com/onlinejudge#question_15";
	}
	

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (num == null || num.length < 3)
			return result;

		Arrays.sort(num);

		for (int i = 0; i < num.length; i++) {

			//only apply when target >= 0
			if (num[i] > 0)
				break;

			int s = i + 1;
			int e = num.length - 1;

			if (i > 0 && num[i] == num[i - 1])
				continue;

			while (s < e) {

				int sum = num[i] + num[s] + num[e];

				if (sum == 0) {
					result.add(toArray(num[i], num[s], num[e]));

					do {
						e--;
					} while (num[e] == num[e + 1] && e > s);

					do {
						s++;
					} while (s < e && num[s] == num[s - 1]);
				} else if (sum > 0) {
					do {
						e--;
					} while (num[e] == num[e + 1] && e > s);
				} else {
					do {
						s++;
					} while (s < e && num[s] == num[s - 1]);
				}

			}
		}

		return result;
	}

	public ArrayList<Integer> toArray(int a, int b, int c) {

		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(a);
		arr.add(b);
		arr.add(c);
		return arr;
	}
}
