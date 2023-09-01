package Problem28;

/* PROBLEM 28
 * Given two strings needle and haystack, return the index of the 
 * first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

	Example 1:
	
	Input: haystack = "sadbutsad", needle = "sad"
	Output: 0
	Explanation: "sad" occurs at index 0 and 6.
	The first occurrence is at index 0, so we return 0.

 */


class Problem28 {
    public int strStr(String haystack, String needle) {
    	return haystack.indexOf(needle);
    }
}

/* MY CODE WITHOUT USING INDEXOF
 * 
 * if(haystack.equals(needle)) {
            return 0;
        }
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            if(haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
 */