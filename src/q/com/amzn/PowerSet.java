package q.com.amzn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PowerSet {

	public static void main(String[] argus) {

		Set<Object> data = new HashSet<Object>();
		data.add(1);
		data.add(2);
		data.add(3);
		data.add(4);
		data.add(5);

		Set<Set<Object>> result = PowerSet.getPowerSet(data);

		System.out.println(result);
		System.out.println(result.size());

	}

	public static Set<Set<Object>> getPowerSet(Set<Object> objects) {

		Set<Set<Object>> result = new HashSet<Set<Object>>();
		Object[] objs = objects.toArray();
		boolean[] selected = new boolean[objects.size()];
		Arrays.fill(selected, false);

		getPowerSet(objs, selected, 0, result);

		return result;

	}

	private static void getPowerSet(Object[] input, boolean[] selected,
			int index, Set<Set<Object>> result) {

		if (index == input.length) {

			Set<Object> set = new HashSet<Object>();

			for (int i = 0; i < input.length; i++) {
				if (selected[i]) {
					set.add(input[i]);
				}
			}

			result.add(set);
			return;
		}

		selected[index] = true;
		getPowerSet(input, selected, index + 1, result);

		selected[index] = false;
		getPowerSet(input, selected, index + 1, result);
	}

}
