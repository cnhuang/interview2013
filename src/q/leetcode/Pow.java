package q.leetcode;

import util.Question;

public class Pow extends Question {

	@Override
	public String getQuestion() {
		//http://discuss.leetcode.com/questions/228/powx-n
		return "http://leetcode.com/onlinejudge#question_50";
	}

	public double pow(double x, int n) {

		if (n == 0)
			return 1.0;
		
		if(n == 1)
			return x;

		double half = pow(x, n / 2);

		if (n % 2 == 0)
			return half * half;
		if (n > 0)
			return half * half * x;

		return half * half / x;

	}

}
