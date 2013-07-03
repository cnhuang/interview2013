package q.leetcode;

import java.util.ArrayList;

import util.Question;

public class TextJustification extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given an array of words and a length L, format the text such that
		 * each line has exactly L characters and is fully (left and right)
		 * justified.
		 * 
		 * You should pack your words in a greedy approach; that is, pack as
		 * many words as you can in each line. Pad extra spaces ' ' when
		 * necessary so that each line has exactly L characters.
		 * 
		 * Extra spaces between words should be distributed as evenly as
		 * possible. If the number of spaces on a line do not divide evenly
		 * between words, the empty slots on the left will be assigned more
		 * spaces than the slots on the right.
		 * 
		 * For the last line of text, it should be left justified and no extra
		 * space is inserted between words.
		 * 
		 * For example, words: ["This", "is", "an", "example", "of", "text",
		 * "justification."] L: 16.
		 */
		return "http://leetcode.com/onlinejudge#question_64";
	}

	public ArrayList<String> fullJustify(String[] words, int L) {

		ArrayList<String> result = new ArrayList<String>();

		if (words == null || words.length == 0)
			return result;

		int index = 0;
		while (index < words.length) {

			ArrayList<String> tmp = new ArrayList<String>();
			int totalLength = 0;

			while (index < words.length) {

				int space = 0;
				if (totalLength != 0)
					space = 1;

				if (words[index].length() + space + totalLength <= L) {
					tmp.add(words[index]);
					totalLength += words[index].length() + space;
					index++;
				} else {
					break;
				}
			}

			if (tmp.size() == 0)
				continue;

			if (index == words.length) {

				StringBuffer sb = new StringBuffer();

				for (int i = 0; i < tmp.size(); i++) {

					if (i != 0) 
						sb.append(" ");
						
					sb.append(tmp.get(i));
				}

				for (int i = sb.length(); i < L; i++)
					sb.append(" ");
				
				result.add(sb.toString());
				continue;
			}

			if (tmp.size() == 1) {
				StringBuffer sb = new StringBuffer();
				sb.append(tmp.get(0));

				for (int i = tmp.get(0).length(); i < L; i++)
					sb.append(" ");

				result.add(sb.toString());
				continue;
			}

			int extraSpace = (L - totalLength) / (tmp.size() - 1);
			int modSpace = (L - totalLength) % (tmp.size() - 1);

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < tmp.size(); i++) {

				if (i != 0) {
					sb.append(" ");

					for (int j = 0; j < extraSpace; j++)
						sb.append(" ");

					if (i <= modSpace)
						sb.append(" ");
				}

				sb.append(tmp.get(i));
			}

			result.add(sb.toString());

		}

		return result;
	}
}
