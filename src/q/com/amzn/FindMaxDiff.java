package q.com.amzn;

import java.util.Random;

public class FindMaxDiff {

	// http://www.careercup.com/question?id=12705676
	// one unsorted array is given.Find out the index i and j ,
	// j> i for which a[j] - a[i] is maximum.perform in linear time complexity

	public static void main(String[] args) {
		Random rand = new Random(System.currentTimeMillis());
		int size = 10;
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = rand.nextInt(20);
			System.out.print(arr[i] + ",");
		}
		System.out.println();
		Find(new int[] { 5, 4, 3, 2, 1, 9, -1, 3 ,12});
		Find(new int[] { -1, -2, -4, -8, -16 });
	}

	public static void Find(int[] arr) {
		
		int maxStartIndex = 0;
		int maxEndIndex = -1;
		int max = Integer.MIN_VALUE;
		int minNumberIndex = maxStartIndex;

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] - arr[minNumberIndex] > max) {
				max = arr[i] - arr[minNumberIndex];
				maxEndIndex = i;
				maxStartIndex = minNumberIndex;
			}

			if (arr[i] < arr[minNumberIndex])
				minNumberIndex = i;

		}

		System.out.println("maxStartIndex = " + maxStartIndex + "("
				+ arr[maxStartIndex] + "), maxEndIndex = " + maxEndIndex + "("
				+ arr[maxEndIndex] + "), Max = " + max);

	}

}
