package q.leetcode;

import java.util.HashMap;
import java.util.Map;

import util.Question;

public class JumpGameII extends Question {

	@Override
	public String getQuestion() {

		/*
		 * Given an array of non-negative integers, you are initially positioned
		 * at the first index of the array.
		 * 
		 * Each element in the array represents your maximum jump length at that
		 * position.
		 * 
		 * Your goal is to reach the last index in the minimum number of jumps.
		 * 
		 * For example: Given array A = [2,3,1,1,4]
		 * 
		 * The minimum number of jumps to reach the last index is 2. (Jump 1
		 * step from index 0 to 1, then 3 steps to the last index.)
		 */
		return "http://leetcode.com/onlinejudge#question_45";
	}

	public int jump(int[] A) {

		if (A == null || A.length == 0)
			return 0;
		
		if(A[0] == 0)
			return 0;

		return jump(A, 0, new HashMap<Integer, Integer>());

	}

	public int jump(int[] A, int index, Map<Integer, Integer> cache) {

		if (index == A.length - 1)
			return 0;
		
		if (cache.containsKey(index))
			return cache.get(index);

		int min = A.length;

		for (int i = 1; i <= A[index] && i + index < A.length; i++) {
			min = Math.min(min, jump(A, index + i, cache)+1);
		}

		cache.put(index, min);

		return min;

	}

}
