package q.com.google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import org.testng.annotations.Test;

import util.Question;

public class MinRangeContainsAllList extends Question {

	@Override
	public String getQuestion() {
		return "http://www.careercup.com/question?id=16759664";
	}

	@Test
	public void find() {

		List<List<Integer>> lists = new LinkedList<List<Integer>>();
		lists.add(Arrays.asList(new Integer[]{4, 10, 15, 24, 26}));
		lists.add(Arrays.asList(new Integer[]{0, 9, 12, 20}));
		lists.add(Arrays.asList(new Integer[]{5, 18, 22, 30}));
		
		
		List<List<Data>> dataLists = new LinkedList<List<Data>>();

		for (List<Integer> list : lists) {

			List<Data> dataList = new LinkedList<Data>();

			for (Integer i : list) {
				Data data = new Data();
				data.value = i;
				data.list = dataList;
				dataList.add(data);
			}
			
			dataLists.add(dataList);
		}

		PriorityQueue<Data> heap = new PriorityQueue<Data>(lists.size(),
				new Comparator<Data>() {

					public int compare(Data arg0, Data arg1) {
						return arg0.value.compareTo(arg1.value);
					}
				});

		int max = Integer.MIN_VALUE;

		for (List<Data> data : dataLists) {
			Data d = data.remove(0);
			
			if (d.value > max)
				max = d.value;

			heap.add(d);
		}

		int minRange = max - heap.peek().value;
		int minStart = heap.peek().value;
		int minEnd = max;

		while (true) {

			Data d = heap.poll();

			if (d.list.size() == 0)
				break;

			Data newData = d.list.remove(0);

			if (newData.value > max)
				max = newData.value;
			
			heap.add(newData);

			int range = max - heap.peek().value;

			if (range < minRange) {
				minRange = max - heap.peek().value;
				minStart = heap.peek().value;
				minEnd = max;
			}
		}

		System.out.println("Min range from:" + minStart + ", to:" + minEnd);

	}

	public static class Data {
		Integer value;
		List<Data> list;
	}
}
