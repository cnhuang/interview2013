package util;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;

public abstract class Question {

	public abstract String getQuestion();

	@BeforeClass(alwaysRun = true)
	public void BeforeClass() {
		Log("\n\n--------- [Question] ------------");
		Log(getQuestion());
		Log("\n");
	}

	@BeforeMethod
	public void BeforeMethod() {
		Log("\n\n==== [Test] ====");
	}
	
	@AfterClass
	public void AfterClass() {
		Log("\n\n---------------------------------");
	}

	public static void Log(Object message) {
		Reporter.log(String.valueOf(message), true);
	}
}
