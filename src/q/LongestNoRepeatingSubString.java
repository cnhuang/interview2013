package q;

import java.util.Arrays;

import util.Question;

public class LongestNoRepeatingSubString extends Question {

	@Override
	public String getQuestion() {
		return "http://leetcode.com/onlinejudge#question_3";
	}
	
	 public int lengthOfLongestSubstring(String s) {
	        // Start typing your Java solution below
	        // DO NOT write main() function.
	        
	        if(s == null || s.length() == 0)
	            return 0;
	            
	        if(s.length() == 1)
	            return 1;
	            
	        
	        int[] flag = new int[26];
	        Arrays.fill(flag,-1);
	       
	        int count = 0;
	        int max = 0;
	        int i = 0;
	        int lastStart = -1;
	        
	        for(char c : s.toCharArray()){
	           
	           int index = c - 'a';
	           
	           if(flag[index] == -1){
	                count++;             
	           }else{
	                lastStart = Math.max(lastStart,flag[index]);
	                count = i-lastStart;
	           }            
	           
	           max = Math.max(max,count);
	           flag[index] = i; 
	           i++;
	        }
	        
	        return max;
	        
	    }

}
