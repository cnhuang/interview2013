package question.string;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import util.Question;

import java.util.*;
import java.util.Map.Entry;

public class FindOrderOfChars extends Question {

	/*
	 * http://www.careercup.com/question?id=13394663
	 * 
	 * @input: sorted strings
	 * 
	 * @output: based on strings find the order of chars
	 * 
	 * @use topology sort
	 */

	@Override
	public String getQuestion() {
		return "Find char order based on input strings";
	}

	@Test(dataProvider = "dataProvider")
	public void find(String[] strs) {

		Set<String> charSet = new HashSet<String>();
		Map<String, Set<String>> inputMap = new HashMap<String, Set<String>>();

		for (int i = 0; i < strs.length - 1; i++) {

			String currentString = strs[i];
			String nextString = strs[i + 1];
			boolean found = false;

			for (int j = 0; j < Math.max(currentString.length(),
					nextString.length()); j++) {

				String charInfront = null;
				String backChar = null;

				if (j < currentString.length()) {
					charInfront = String.valueOf(currentString.charAt(j));
					if (!charSet.contains(charInfront)) {
						Log("found char:" + charInfront);
						charSet.add(charInfront);
					}
				}

				if (j < nextString.length()) {
					backChar = String.valueOf(nextString.charAt(j));
					if (!charSet.contains(backChar)) {
						Log("found char:" + backChar);
						charSet.add(backChar);
					}
				}

				if (!found && charInfront != null && backChar != null
						&& !charInfront.equals(backChar)) {

					if (!inputMap.containsKey(backChar)) {
						inputMap.put(backChar, new HashSet<String>());
					}

					if (!inputMap.get(backChar).contains(charInfront))
						inputMap.get(backChar).add(charInfront);

					found = true;
				}
			}
		}

		// Topology sort

		List<String> noParentChars = new LinkedList<String>();

		while (noParentChars.size() != charSet.size()) {

			for (String c : charSet) {

				if (!inputMap.containsKey(c) || inputMap.get(c).size() == 0) {

					if (!noParentChars.contains(c)) {
						noParentChars.add(c);
						Log("add char:" + c);
					}

					for (Entry<String, Set<String>> entry : inputMap.entrySet()) {
						entry.getValue().remove(c);
					}
				} else {
					Log(inputMap);
				}
			}
		}

		Log("Resutl:" + noParentChars);

	}

	@DataProvider
	public static Object[][] dataProvider() {

		String[] strSet1 = "AALS,AARDVARK,AARDVARKS,AARDWOLF,AARDWOLVES,AARGH,AARRGH,AARRGHH"
				.split(",");

		return new Object[][] { { strSet1 } };

	}

}
