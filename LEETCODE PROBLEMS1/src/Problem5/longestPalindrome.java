package Problem5;

/* PROBLEM 5
 * 
 * Given a string s, return the longest palindromic substring in s.
 * 
 */

class Problem5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}


/* My Code
 * 
 * class Solution {
    public String longestPalindrome(String s) {
        String p = "";
        String re = "";
        for(int i = s.length() -1; i >= 0; i--) {
            re += s.charAt(i);
        }
        if(re.equals(s)) {
            return s;
        }
        int length = 0;
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            j = i;
            while(j < s.length()) {
                if(s.substring(i, j + 1).equals(re.substring(s.length() - j - 1, s.length()- i)) && s.substring(i,j + 1).length() > length) {
                    p = s.substring(i, j + 1);
                    length = p.length();
                }
                j++;
            }
            if(i + p.length() > s.length()) {
                 break;
            }

        }
        return p;
    }
}
*/

