package question;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.testng.annotations.Test;

import ds.Pair;

import util.Question;

public class FindPairWithMaxOverlap extends Question {

	@Override
	public String getQuestion() {
		return "http://www.careercup.com/question?id=12743699 Given a set of Pairs. "
				+ "find the Pair which has the maximum number of intersections.	 ";
	}

	@Test
	public void find() {

		List<Pair<Integer>> data = GetTestData(10);
		Log("TestData:" + data.toString());

		List<Atom> atomList = new LinkedList<Atom>();

		for (Pair<Integer> pair : data) {
			atomList.add(new Atom("start", pair.Value1, pair));
			atomList.add(new Atom("end", pair.Value2, pair));
		}

		Comparator<Atom> c = new Comparator<Atom>() {
			public int compare(Atom arg0, Atom arg1) {
				return arg0.v.compareTo(arg1.v);
			}
		};

		Collections.sort(atomList, c);

		int maxCount = Integer.MIN_VALUE;
		Pair<Integer> maxPair = null;

		Map<Pair<Integer>, Integer> overlapCount = new HashMap<Pair<Integer>, Integer>();

		for (Atom atom : atomList) {
			if (atom.t.equals("start")) {
				// add new interval into map
				overlapCount.put(atom.p, 0);
				for (Entry<Pair<Integer>, Integer> entry : overlapCount
						.entrySet()) {

					// increase count for all intervals in the map
					int overlap = entry.getValue() + 1;

					// find max overlapped interval
					if (overlap > maxCount) {
						maxCount = overlap;
						maxPair = entry.getKey();
					}
					entry.setValue(overlap);
				}
			} else {
				// kick out the ended interval
				overlapCount.remove(atom.p);
			}
		}

		Log("Maxoverlap pair:" + maxPair + ", overlaps:" + maxCount);
	}

	private static class Atom {

		String t;
		Integer v;
		Pair<Integer> p;

		public Atom(String type, int value, Pair<Integer> pair) {
			t = type;
			v = value;
			p = pair;
		}
	}

	private static List<Pair<Integer>> GetTestData(int n) {
		List<Pair<Integer>> data = new LinkedList<Pair<Integer>>();
		Random rand = new Random(System.currentTimeMillis());

		for (int i = 0; i < n; i++) {
			int n1 = 0;
			int n2 = 0;

			while (n1 == n2) {
				n1 = rand.nextInt(500);
				n2 = rand.nextInt(500);

				if (n1 > n2)
					data.add(new Pair<Integer>(n2, n1));
				else
					data.add(new Pair<Integer>(n1, n2));
			}
		}

		return data;
	}

}
