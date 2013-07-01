package q.leetcode;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import util.Question;

public class MinimumPathSum extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a m x n grid filled with non-negative numbers, find a path from
		 * top left to bottom right which minimizes the sum of all numbers along
		 * its path.
		 * 
		 * Note: You can only move either down or right at any point in time.
		 */
		return "http://leetcode.com/onlinejudge#question_64";
	}

	@Test
	public void test() {
		Log(minPathSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }));
	}

	public int minPathSum(int[][] grid) {

		return minPathSum(grid, 0, 0, new HashMap<Integer, Integer>());

	}

	public int minPathSum(int[][] grid, int row, int col, Map<Integer, Integer> cache) {

		int index = row * grid[0].length + col;

		if (cache.containsKey(index)) {
			Log("return:(" + row + "," + col + "), index:" + index + ":" + cache.get(index));
			 return cache.get(index);
		}

		int min = Integer.MAX_VALUE;

		if (col + 1 < grid[0].length) {
			min = Math.min(min, minPathSum(grid, row, col + 1, cache));
		}

		if (row + 1 < grid.length) {
			min = Math.min(min, minPathSum(grid, row + 1, col, cache));
		}

		if (min == Integer.MAX_VALUE)
			min = grid[row][col];
		else
			min += grid[row][col];

		Log("put:(" + row + "," + col + "), index:" + index + ":" + min);
		cache.put(index, min);

		return min;
	}

}
