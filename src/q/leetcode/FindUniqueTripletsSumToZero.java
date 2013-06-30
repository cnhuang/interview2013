package q.leetcode;

import util.Question;

public class FindUniqueTripletsSumToZero extends Question {

	@Override
	public String getQuestion() {
		/**
		 * Given a set S of n integers, are there elements a, b, c in S such
		 * that a + b + c = 0? Find all unique triplets in the set which gives
		 * the sum of zero.
		 * 
		 * For example, given set S = {-1 0 1 2 -1 -4},
		 * 
		 * One possible solution set is: (-1, 0, 1) (-1, 2, -1)
		 * 
		 * Note that (0, 1, -1) is not part of the solution above, because (0,
		 * 1, -1) is the duplicate of (-1, 0, 1). Same with (-1, -1, 2).
		 * 
		 * For a set S, there is probably no ¡§the¡¨ solution, another solution
		 * could be: (0, 1, -1) (2, -1, -1)
		 */
		return "http://leetcode.com/2010/04/finding-all-unique-triplets-that-sums.html";
	}

	// three sum problem
	// 1. sort array
	// 2. for(int i = 0 ; i < n ; i++)
	// 3. 2 pointers start = i+1, end = n-1
	// 4. if(start + end + i > 0) end--, else = 0, else < 0 -> s++

}
