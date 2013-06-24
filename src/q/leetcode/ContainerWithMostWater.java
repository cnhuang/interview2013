package q.leetcode;

import org.testng.annotations.Test;

import util.Question;

public class ContainerWithMostWater extends Question {

	@Override
	public String getQuestion() {

		/**
		 * Given n non-negative integers a1, a2, ..., an, where each represents
		 * a point at coordinate (i, ai). n vertical lines are drawn such that
		 * the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
		 * which together with x-axis forms a container, such that the container
		 * contains the most water.
		 */

		return "http://leetcode.com/onlinejudge#question_11";
	}

	@Test
	public void find_efficient(Integer[] height) {

		//http://discuss.leetcode.com/questions/193/container-with-most-water
		
		int maxArea = 0;

		int i = 0;
		int j = height.length-1;
		
		
		
		while(i <j){
			int area = Math.min(height[i], height[j])*(j-1);
			maxArea = Math.max(area, maxArea);
			
			if(height[i] < height[j])
				i++;
			else
				j--;
		} 

		Log(maxArea);
	}

	@Test
	public void find_bruteForce(Integer[] height) {

		int maxArea = 0;

		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {

				int area = Math.min(height[i], height[j]) * (j - i);
				maxArea = Math.max(area, maxArea);
			}
		}

		Log(maxArea);

	}

}
