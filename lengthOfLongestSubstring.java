package Problem3;
import java.util.HashMap;
import java.util.Map;

/* PROBLEM 3
 * 
 * Given a string s, find the length of the longest substring
 * without repeating characters.*/


	class Problem_3 {
		
		public int lengthOfLongestSubstring(String s) {
	        Map<Character, Integer> map = new HashMap<>();
	        int maxLength = 0;
	        int i = 0;
	        int j = 0;
	        while(i < s.length() && j < s.length()){
	            if(map.containsKey(s.charAt(j))){
	                i = Math.max(map.get(s.charAt(j)), i);
	            }
	            maxLength = Math.max(maxLength, j - i + 1);
	            map.put(s.charAt(j), j + 1);
	            j++;
	        }
	        return maxLength;
	    }
}

