package q.leetcode;

import util.Question;

public class MergeSortedArray extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given two sorted integer arrays A and B, merge B into A as one sorted
		 * array.
		 * 
		 * Note: You may assume that A has enough space to hold additional
		 * elements from B. The number of elements initialized in A and B are m
		 * and n respectively.
		 */
		return "http://leetcode.com/onlinejudge#question_88";
	}

	public void merge(int A[], int m, int B[], int n) {

		if (n == 0)
			return;

		int indA = m - 1;
		int indB = n - 1;

		int current = A.length - 1;

		while (current >= 0) {

			if (indB < 0) {
				A[current--] = A[indA--];
			} else if (indA < 0) {
				A[current--] = B[indB--];
			} else if (A[indA] > B[indB]) {
				A[current--] = A[indA--];
			} else {
				A[current--] = B[indB--];
			}

		}

	}
}
