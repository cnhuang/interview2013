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
		ArrayList<Interval> result = insert(intervals, new Interval(0, 20));
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

		for (Interval interval : intervals) {

			if (newInterval == null) {
				result.add(interval);
			} else if (newInterval.end < interval.start) {
				// important
				result.add(newInterval);
				result.add(interval);
				newInterval = null;
			} else if (newInterval.start > interval.end) {
				// important: can't add newInterval, since multiple interval
				// could < newInterval
				result.add(interval);
			} else {
				newInterval.start = Math.min(newInterval.start, interval.start);
				newInterval.end = Math.max(newInterval.end, interval.end);
			}
		}

		if (null != newInterval)
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
