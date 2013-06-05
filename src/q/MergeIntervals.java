package q;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ds.Pair;

import util.Question;

public class MergeIntervals extends Question {

	/**
	 * http://www.careercup.com/question?id=13014685 Given a set of non
	 * overlapping intervals
	 * 
	 * @Example1 (1,4) (6,10) (14, 19) and another interval (13, 17) merge them
	 *           as (1,4) (6,10) (13,19)
	 * @Example2 (1,5) (6, 15) (20, 21) (23, 26) (27, 30) (35, 40) New interval
	 *           (14, 33) Output should be (1,5) (6, 33) (35, 40)
	 */
	public String getQuestion() {
		return "Merge Intervals";
	}

	@Test(dataProvider = "dataProvider")
	public void merge(List<Pair<Integer>> dataList, Pair<Integer> pair) {

		Log("\nMerge " + pair + " into " + dataList);

		// can be faster if we check pair > all data or pair < all data first

		Stack<Pair<Integer>> result = new Stack<Pair<Integer>>();
		result.push(pair);

		for (Pair<Integer> data : dataList) {

			Pair<Integer> p = result.pop();

			boolean intersection = !(p.Value2 < data.Value1 || p.Value1 > data.Value2);

			if (intersection) {

				p = new Pair<Integer>(Math.min(p.Value1, data.Value1), Math.max(p.Value2,
						data.Value2));
				result.push(p);

			} else {

				if (p.Value2 < data.Value1) {
					result.add(p);
					result.add(data);
				} else {
					result.add(data);
					result.add(p);
				}
			}
		}

		Log("Result:" + result);

	}

	@DataProvider
	public static Object[][] dataProvider() {

		List<Pair<Integer>> data = new LinkedList<Pair<Integer>>();
		data.add(new Pair<Integer>(1, 5));
		data.add(new Pair<Integer>(6, 15));
		data.add(new Pair<Integer>(20, 21));
		data.add(new Pair<Integer>(23, 26));
		data.add(new Pair<Integer>(27, 30));
		data.add(new Pair<Integer>(35, 40));

		return new Object[][] { { data, new Pair<Integer>(-1, 0) },
				{ data, new Pair<Integer>(-1, 3) }, { data, new Pair<Integer>(1, 5) },
				{ data, new Pair<Integer>(16, 18) }, { data, new Pair<Integer>(8, 28) },
				{ data, new Pair<Integer>(24, 28) }, { data, new Pair<Integer>(22, 28) },
				{ data, new Pair<Integer>(24, 31) }, { data, new Pair<Integer>(22, 31) },
				{ data, new Pair<Integer>(2, 39) }, { data, new Pair<Integer>(1, 40) },
				{ data, new Pair<Integer>(41, 50) }, };
	}
}
