package q.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import util.Question;

public class MergeIntervals extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a collection of intervals, merge all overlapping intervals.
		 * 
		 * For example, Given [1,3],[2,6],[8,10],[15,18], return
		 * [1,6],[8,10],[15,18].
		 */
		return "http://leetcode.com/onlinejudge#question_56";
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

		ArrayList<Interval> result = new ArrayList<Interval>();

		if (intervals == null || intervals.size() == 0)
			return result;

		Collections.sort(intervals, new Comparator<Interval>() {

			public int compare(Interval arg0, Interval arg1) {
				return arg0.start - arg1.start;
			}

		});

		Interval data = null;

		for (Interval interval : intervals) {

			if (data == null) {
				data = interval;
				continue;
			}

			if (interval.start > data.end) {
				result.add(data);
				data = interval;
			} else {
				data.end = Math.max(data.end,interval.end);
			}
		}

		if (data != null)
			result.add(data);

		return result;

	}

	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}
