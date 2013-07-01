package q.leetcode;

import java.util.ArrayList;

import org.testng.annotations.Test;

import util.Question;

public class InsertIntervals extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a set of non-overlapping intervals, insert a new interval into
		 * the intervals (merge if necessary).
		 * 
		 * You may assume that the intervals were initially sorted according to
		 * their start times.
		 * 
		 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
		 * [1,5],[6,9].
		 * 
		 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge
		 * [4,9] in as [1,2],[3,10],[12,16].
		 * 
		 * This is because the new interval [4,9] overlaps with
		 * [3,5],[6,7],[8,10].
		 */
		return "http://leetcode.com/onlinejudge#question_57";
	}

	@Test
	public void test() {

		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(0, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 8));
		intervals.add(new Interval(10, 12));
		intervals.add(new Interval(13, 15));
		ArrayList<Interval> result = insert(intervals, new Interval(4, 7));
		Log(result);
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

		ArrayList<Interval> result = new ArrayList<Interval>();

		if (intervals == null || intervals.size() == 0) {
			if (newInterval != null)
				result.add(newInterval);
			return result;
		}

		if (newInterval == null) {
			return intervals;
		}

		int index = 0;

		while (index < intervals.size()) {

			Interval interval = intervals.get(index);
			if (interval.end < newInterval.start) {
				index++;
				result.add(interval);
			} else
				break;
		}

		while (index < intervals.size()) {

			Interval interval = intervals.get(index);
			if (interval.start <= newInterval.end) {
				newInterval.start = Math.min(interval.start, newInterval.start);
				newInterval.end = Math.max(interval.end, newInterval.end);
				index++;
			} else {
				result.add(newInterval);
				newInterval = null;
				break;
			}
		}

		while (index < intervals.size()) {
			Interval interval = intervals.get(index);
			index++;
			result.add(interval);
		}

		if (newInterval != null)
			result.add(newInterval);

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

		public String toString() {
			return "(" + start + "," + end + ")";
		}
	}

}
