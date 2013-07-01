package q.leetcode;

import java.util.Arrays;

import util.Question;

public class ThreeSumClosestToTarget extends Question {

	@Override
	public String getQuestion() {
		return "http://leetcode.com/onlinejudge#question_16";
	}

	public int threeSumClosest(int[] num, int target) {

		if (num == null || num.length < 3)
			return -1;

		Arrays.sort(num);

		Integer diff = null;
		Integer result = null;

		for (int i = 0; i < num.length; i++) {

			int s = i + 1;
			int e = num.length - 1;

			if (result != null && diff > 0 && num[i] - target > diff)
				return result;

			if (i > 0 && num[i] == num[i - 1])
				continue;

			while (s < e) {

				int sum = num[i] + num[s] + num[e];

				if (sum == target)
					return target;

				int d = Math.abs(sum - target);

				if (diff == null || d < diff) {
					diff = d;
					result = sum;
				}

				if (sum > target) {
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

		return result.intValue();
	}

}
