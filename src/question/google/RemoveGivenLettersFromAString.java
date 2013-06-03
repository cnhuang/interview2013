package question.google;

import org.junit.Test;

import util.Question;

public class RemoveGivenLettersFromAString extends Question
{

	@Override
	public String getQuestion() {
		
		return "Remove chars in a given char list from a given string.(Hint: has to ask what is the char range? ASCII or Unicode).";
	}
	
	@Test
	public void remove(){
		Log("Use bit array to mark which char need to be removed. Then scan the given string");
	}

}
