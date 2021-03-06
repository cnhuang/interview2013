package util;

import java.io.*;
import java.util.*;

public class Dictionary
{
	static List<String> words;
	static Random rand = new Random(System.currentTimeMillis());

	private static List<String> GetDictionary()
	{
		if (words == null)
		{
			words = new ArrayList<String>();

			try
			{
				System.out.println("Loading Dictionary....");
				// Open the file that is the first
				// command line parameter
				FileInputStream fstream = new FileInputStream("Dictionary.txt");
				// Get the object of DataInputStream
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String strLine;
				// Read File Line By Line
				while ((strLine = br.readLine()) != null)
				{
					words.add(strLine);
				}
				// Close the input stream
				in.close();

				System.out.println(words.size() + " Words Loaded.");
			} catch (Exception e)
			{// Catch exception if any
				System.err.println("Error: " + e.getMessage());
			}
		}

		return words;

	}

	public static List<String> GetWords()
	{
		if (words == null)
			words = GetDictionary();

		return words;
	}

	public static List<String> GetWords(int N)
	{
		List<String> strs = new ArrayList<String>();

		while (strs.size() < N)
		{
			String str = GetWords().get(rand.nextInt(GetWords().size()));
			if (!strs.contains(str))
				strs.add(str);
		}

		Collections.sort(strs);
		return strs;
	}

	public static boolean IsWord(String word)
	{
		word = word.toUpperCase();
		return GetDictionary().contains(word);
	}
}
