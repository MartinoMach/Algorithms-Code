package Problem49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* PROBLEM 49
 * 
 * Given an array of strings strs, group the anagrams together. 
 * You can return the answer in any order.
 *
 *An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
 *typically using all the original letters exactly once.

 

	Example 1:
	
	Input: strs = ["eat","tea","tan","ate","nat","bat"]
	Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
	Example 2:
	
	Input: strs = [""]
	Output: [[""]]
	Example 3:
	
	Input: strs = ["a"]
	Output: [["a"]]


 */


class Problem49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> ans = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) {
               ans.put(key, new ArrayList<>()); 
            }
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }
}