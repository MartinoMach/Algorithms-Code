package Problem17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* PROBLEM 17
 * 
 * Given a string containing digits from 2-9 inclusive, 
 * return all possible letter combinations that the number could represent. 
 * 
 * Return the answer in any order.
 * 
 * A mapping of digits to letters (just like on the telephone buttons) is given below. 
 * 
 * Note that 1 does not map to any letters.
 * 
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 */


class Problem17 {
    public List<String> letterCombinations(String digits) {
        Map<Character,String> map = new HashMap<>();
        List<String> combo = new ArrayList<String>();
        if(digits.length() == 0){
            return combo;
        }
        String s = "";
        map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        boolean t = false;
        int start = 0;
        while (t == false && start < digits.length()) {
        	if(!map.get(digits.charAt(start)).equals("")) {
        		for(int index = 0; index < map.get(digits.charAt(start)).length(); index++) {
                    combo.add(map.get(digits.charAt(start)).substring(index, index+1));
                }
        		t = true;
        	}
        	start++;
        	
        }

        for(int in = start ; in < digits.length(); in++) {
        	s = map.get(digits.charAt(in));
        	if(s.length() != 0) {
        		List<String> answer = new ArrayList<String>();
                for(int i = 0; i < combo.size(); i++) {
                    for(int j = 0; j < s.length(); j++) {
                        String letter = combo.get(i);
                        letter+= s.substring(j,j+1);
                        answer.add(letter);
                    }   
                }
                combo = new ArrayList<>(answer);
        	}
        }
        return combo;
    }
}
/* MY CODE BUT STILL WORKS
 * class Solution {
 
    public List<String> letterCombinations(String digits) {
        Map<Character,String> map = new HashMap<>();
        List<String> combo = new ArrayList<String>();
        if(digits.length() == 0){
            return combo;
        }
        String s = "";
        map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        for(int index = 0; index < map.get(digits.charAt(0)).length(); index++) {
            combo.add(map.get(digits.charAt(0)).substring(index, index+1));
        }

        for(int in = 1; in < digits.length(); in++) {
            List<String> answer = new ArrayList<String>();
            s = map.get(digits.charAt(in));
            for(int i = 0; i < combo.size(); i++) {
                for(int j = 0; j < s.length(); j++) {
                    String letter = combo.get(i);
                    letter+= s.substring(j,j+1);
                    answer.add(letter);
                }   
            }
            combo = new ArrayList<>(answer);
        }
        return combo;
    }
}*/