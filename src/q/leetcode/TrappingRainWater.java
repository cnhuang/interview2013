package q.leetcode;

import util.Question;

public class TrappingRainWater extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given n non-negative integers representing an elevation map where the
		 * width of each bar is 1, compute how much water it is able to trap
		 * after raining.
		 * 
		 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
		 * 
		 * 
		 * 
		 * The above elevation map is represented by array
		 * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue
		 * section) are being trapped. Thanks Marcos for contributing this
		 * image!
		 */
		return "http://leetcode.com/onlinejudge#question_42";
	}

	public int trap(int[] A) {

		if (A == null || A.length == 0) {
			return 0;
		}

		int[] leftMax = new int[A.length];

		int max = 0;

		for (int i = 0; i < A.length; i++) {

			leftMax[i] = max;
			max = Math.max(max, A[i]);
		}

		int[] rightMax = new int[A.length];

		max = 0;

		for (int i = A.length - 1; i >= 0; i--) {

			rightMax[i] = max;
			max = Math.max(max, A[i]);
		}
		
		int count = 0;
		for(int i = 0 ; i < A.length ; i++){
			count +=Math.max(0,Math.min(rightMax[i], leftMax[i]) - A[i]);
		}
		
		return count;

	}

}
