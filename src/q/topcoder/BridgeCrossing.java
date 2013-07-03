package q.topcoder;

import static org.testng.AssertJUnit.assertEquals;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class BridgeCrossing extends Question {

	@Override
	public String getQuestion() {
		/*
		 * A well-known riddle goes like this: Four people are crossing an old
		 * bridge. The bridge cannot hold more than two people at once. It is
		 * dark, so they can't walk without a flashlight, and they only have one
		 * flashlight! Furthermore, the time needed to cross the bridge varies
		 * among the people in the group. For instance, let's say that the
		 * people take 1, 2, 5 and 10 minutes to cross the bridge. When people
		 * walk together, they always walk at the speed of the slowest person.
		 * It is impossible to toss the flashlight across the bridge, so one
		 * person always has to go back with the flashlight to the others. What
		 * is the minimum amount of time needed to get all the people across the
		 * bridge?
		 * 
		 * In this instance, the answer is 17. Person number 1 and 2 cross the
		 * bridge together, spending 2 minutes. Then person 1 goes back with the
		 * flashlight, spending an additional one minute. Then person 3 and 4
		 * cross the bridge together, spending 10 minutes. Person 2 goes back
		 * with the flashlight (2 min), and person 1 and 2 cross the bridge
		 * together (2 min). This yields a total of 2+1+10+2+2 = 17 minutes
		 * spent.
		 * 
		 * You want to create a computer program to help you solve new instances
		 * of this problem. Given an int[] times, where the elements represent
		 * the time each person spends on a crossing, your program should return
		 * the minimum possible amount of time spent crossing the bridge.
		 */
		return "http://community.topcoder.com/stat?c=problem_statement&pm=1599&rd=4535";
	}

	@Test(dataProvider = "dataProvider")
	public void minTime(int[] ppl, int ans) {

		int calculated = 0;

		if (ppl.length == 1)
			calculated = ppl[0];
		else if (ppl.length == 2) {
			calculated = Math.max(ppl[0], ppl[1]);
		} else {

			boolean[] crossed = new boolean[ppl.length];
			calculated = minTime(ppl, crossed, 0, true);
		}

		assertEquals(ans, calculated);
	}

	public int minTime(int[] ppl, boolean[] crossed, int crossedPPl, boolean go) {

		if (crossedPPl == ppl.length)
			return 0;

		if (go) {

			if (ppl.length - crossedPPl == 1) {
				int left = -1;
				for (int i = 0; i < crossed.length; i++) {
					if (!crossed[i]) {
						left = i;
						break;

					}
				}

				crossed[left] = true;
				int time = minTime(ppl, crossed, crossedPPl + 1, false) + ppl[left];
				crossed[left] = false;
				return time;

			} else {

				List<Pair> pairs = getPairs(ppl, crossed);

				int min = Integer.MAX_VALUE;

				for (Pair pair : pairs) {

					crossed[pair.ppl1Index] = true;
					crossed[pair.ppl2Index] = true;

					min = Math.min(
							min,
							minTime(ppl, crossed, crossedPPl + 2, false)
									+ Math.max(pair.ppl1, pair.ppl2));

					crossed[pair.ppl1Index] = false;
					crossed[pair.ppl2Index] = false;
				}
				return min;
			}

		} else {
			int fastest = findFastestInCrossed(ppl, crossed);
			crossed[fastest] = false;
			int time = minTime(ppl, crossed, crossedPPl - 1, true) + ppl[fastest];
			crossed[fastest] = true;
			return time;
		}
	}

	public static class Pair {
		int ppl1;
		int ppl2;
		int ppl1Index;
		int ppl2Index;

		public Pair(int p1, int p2, int p1Index, int p2Index) {
			ppl1 = p1;
			ppl2 = p2;
			ppl1Index = p1Index;
			ppl2Index = p2Index;
		}
	}

	public List<Pair> getPairs(int[] ppl, boolean crossed[]) {

		List<Pair> pairs = new LinkedList<Pair>();

		for (int i = 0; i < ppl.length; i++) {

			if (!crossed[i]) {
				for (int j = i + 1; j < ppl.length; j++) {
					if (!crossed[j]) {
						pairs.add(new Pair(ppl[i], ppl[j], i, j));
					}
				}
			}
		}

		return pairs;

	}

	public int findFastestInCrossed(int[] ppl, boolean crossed[]) {

		int ind = -1;

		for (int i = 0; i < ppl.length; i++) {
			if (crossed[i]) {
				if (ind == -1 || ppl[i] < ppl[ind]) {
					ind = i;
				}
			}
		}

		return ind;
	}

	@DataProvider
	public static Object[][] dataProvider() {

		return new Object[][] {

		{ new int[] { 1, 2, 5, 10 }, 17 },

		{ new int[] { 100 }, 100 },

		{ new int[] { 1, 2, 3, 50, 99, 100 }, 162 }, };
	}
}
