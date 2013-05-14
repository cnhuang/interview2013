package interview2013.questions.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import interview2013.util.Question;

public class AStar extends Question {

	@Override
	public String getQuestion() {
		String str = "A* uses a best-first search and finds a least-cost path from a given initial node to one goal node\n";
		return str;
	}

	@Test(dataProvider = "dataProvider")
	public void findPath(String start, String end,
			Map<String, Integer> heuristicDistMap,
			Map<String, Map<String, Integer>> actualDistMap) {

		Set<String> openSet = new HashSet<String>();
		Set<String> closeSet = new HashSet<String>();
		Map<String, String> cameFrom = new HashMap<String, String>();

		Map<String, Integer> actualCost = new HashMap<String, Integer>();
		Map<String, Integer> heuristicCost = new HashMap<String, Integer>();

		openSet.add(start);
		actualCost.put(start, 0);
		heuristicCost.put(start, 0);

		while (openSet.size() > 0) {

			// get closest
			String current = null;
			int dest = Integer.MAX_VALUE;

			for (String n : openSet) {
				if (heuristicCost.get(n) < dest) {
					dest = heuristicCost.get(n);
					current = n;
				}
			}

			Log("current:" + current);

			if (current == end) {

				String pathString = "";
				while (true) {
					pathString += current + "=>";
					current = cameFrom.get(current);
					if (current == start) {
						pathString += current;
						Log(pathString);
						Log("Cost:" + actualCost.get(end));
						return;
					}
				}
			}

			closeSet.add(current);
			openSet.remove(current);

			// calculate dist for next run

			for (String n : actualDistMap.get(current).keySet()) {

				Integer actualDist = actualCost.get(current)
						+ actualDistMap.get(current).get(n);
				Integer heuristicDist = actualDist
						+ (heuristicDistMap.containsKey(n) ? heuristicDistMap.get(n) : 0);

				if (closeSet.contains(n) && actualCost.get(n) <= actualDist)
					continue;

				if (!openSet.contains(n) || actualCost.get(n) > actualDist) {
					cameFrom.put(n, current);
					actualCost.put(n, actualDist);
					heuristicCost.put(n, heuristicDist);

					if (!openSet.contains(n)) {
						openSet.add(n);
					}
				}
			}
		}
	}

	@DataProvider
	public static Object[][] dataProvider() {
		// http://stackoverflow.com/questions/5849667/a-search-algorithm
		Map<String, Integer> heuristic = new HashMap<String, Integer>();
		heuristic.put("A", 5);
		heuristic.put("B", 6);
		heuristic.put("C", 4);
		heuristic.put("D", 15);
		heuristic.put("X", 5);
		heuristic.put("Y", 8);

		Map<String, Map<String, Integer>> actual = new HashMap<String, Map<String, Integer>>();

		Map<String, Integer> map = new HashMap<String, Integer>();
		actual.put("S", map);
		map.put("A", 1);
		map.put("B", 2);

		map = new HashMap<String, Integer>();
		actual.put("A", map);
		map.put("X", 4);
		map.put("Y", 7);

		map = new HashMap<String, Integer>();
		actual.put("B", map);
		map.put("C", 7);
		map.put("D", 1);

		map = new HashMap<String, Integer>();
		actual.put("C", map);
		map.put("E", 5);

		map = new HashMap<String, Integer>();
		actual.put("C", map);
		map.put("E", 5);

		map = new HashMap<String, Integer>();
		actual.put("D", map);
		map.put("E", 12);

		map = new HashMap<String, Integer>();
		actual.put("X", map);
		map.put("E", 2);

		map = new HashMap<String, Integer>();
		actual.put("Y", map);
		map.put("E", 3);

		return new Object[][] { { "S", "E", heuristic, actual } };

	}
}
