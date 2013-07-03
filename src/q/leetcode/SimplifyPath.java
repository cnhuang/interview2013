package q.leetcode;

import java.util.Stack;

import org.testng.annotations.Test;

import util.Question;

public class SimplifyPath extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given an absolute path for a file (Unix-style), simplify it.
		 * 
		 * For example, path = "/home/", => "/home" path = "/a/./b/../../c/", =>
		 * "/c"
		 */
		return "http://leetcode.com/onlinejudge#question_71";
	}

	@Test
	public void test() {
		Log(simplifyPath("/./"));
	}

	public String simplifyPath(String path) {

		if (path == null || path.length() == 0)
			return path;


	    Stack<String> stack = new Stack<String>();
	    String[] splits = path.trim().split("/");
	    for (String s : splits) {
	        if (s == null || s.length() == 0 || s.equals(".")) {
	            // Do nothing;
	        } else if (s.equals("..")) {
	            // Pop if stack is not empty;
	            if (stack.size() > 0) stack.pop();
	        } else {
	            // Push all others to stack.
	            stack.push(s);
	        }
	    }

	    // Remember, stack can be empty.
	    if (stack.isEmpty()) return "/";

	    StringBuffer buf = new StringBuffer();
	    while (!stack.isEmpty()) {
	        buf.insert(0, stack.pop());
	        buf.insert(0, "/");
	    }

	    return buf.toString();

	}

}
