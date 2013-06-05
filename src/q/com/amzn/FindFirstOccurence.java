package q.com.amzn;

import java.util.Arrays;
import java.util.LinkedList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class FindFirstOccurence extends Question {

	@Override
	public String getQuestion() {

		return "You have an array of binary numbers as \"00001101000001010100000...\"...\n"
				+ " We need to find the First occurrence of 1 in this series.. using binary search. \n"
				+ "we need to design an algorithm of complexity less than O(n).. and we need to use binary search strictly..";
	}

	@Test(dataProvider = "dataProvider")
	public void find_recursive(Integer[] arr) {
		Log("Input:" + Arrays.toString(arr));
		Log("First Occurence:" + find_recursive(arr, 0, arr.length - 1));
	}

	private int find_recursive(Integer[] arr, int start, int end) {

		if (start > end)
			return -1;

		Log("Search from:" + start + " to:" + end);

		int middle = (start + end) / 2;

		int leftChild = find_recursive(arr, start, middle - 1);

		if (leftChild != -1) {
			return leftChild;
		}

		if (arr[middle] == 1) {
			return middle;
		}

		return find_recursive(arr, middle + 1, end);

	}

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {

		return new Object[][] {
				{ new Integer[] { 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0,
						1, 0, 1, 0, 0, 0, 0, 0 } },
				{ new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0 } },
				{ new Integer[] { 1, 1, 1, 1, 1, 1, 1, 1, 1 } },
				{ new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 1 } },
				{ new Integer[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0 } }, { new Integer[] { 0 } },
				{ new Integer[] { 1 } } };

	}

}
