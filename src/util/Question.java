package util;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;

public abstract class Question {

	public abstract String getQuestion();

	@BeforeClass(alwaysRun = true)
	public void BeforeClass() {
		Log("\n\n--------- [Question] ------------");
		Log(getQuestion());
		Log("\n");
	}

	public void Log(String message) {
		Reporter.log(message, true);
	}
}
