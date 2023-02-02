package Problem44;


/* PROBLEM 44
 * 
 * Given an input string (s) and a pattern (p), implement wildcard pattern 
 * matching with support for '?' and '*' where:

	'?' Matches any single character.
	'*' Matches any sequence of characters (including the empty sequence).
	The matching should cover the entire input string (not partial).

 

	Example 1:
	
	Input: s = "aa", p = "a"
	Output: false
	Explanation: "a" does not match the entire string "aa".
	Example 2:
	
	Input: s = "aa", p = "*"
	Output: true
	Explanation: '*' matches any sequence.
	Example 3:
	
	Input: s = "cb", p = "?a"
	Output: false
	Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

 */


class Problem44 {
    public boolean isMatch(String s, String p) {
        int sIndex = 0;
        int pIndex = 0;
        int matchIndex = 0;
        int starIndex = -1;
    
        while (sIndex < s.length()) {
            if (pIndex < p.length() && (p.charAt(pIndex) == '?' || p.charAt(pIndex) == s.charAt(sIndex))) {
                sIndex++;
                pIndex++;
            } else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                starIndex = pIndex;
                matchIndex = sIndex;
                pIndex++;
            } else if (starIndex == -1) {
                return false;
            } else {
            pIndex = starIndex + 1;
            matchIndex++;
            sIndex = matchIndex;
            }
        }
	    for (int i = pIndex; i < p.length(); i++) {
	        if (p.charAt(i) != '*') {
	            return false;
	        }
	    }
	    return true;
    }
}