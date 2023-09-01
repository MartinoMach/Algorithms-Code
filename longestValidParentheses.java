package Problem32;


import java.util.Stack;

/* PROBLEM 32
 * 
 * Given a string containing just the characters '(' and ')', 
 * return the length of the longest valid (well-formed) parentheses substring.

 

	Example 1:
	
	Input: s = "(()"
	Output: 2
	Explanation: The longest valid parentheses substring is "()".
	Example 2:
	
	Input: s = ")()())"
	Output: 4
	Explanation: The longest valid parentheses substring is "()()".
	Example 3:
	
	Input: s = ""
	Output: 0
 * 
 */


class Problem32 {
    public int longestValidParentheses(String s) {
        if (s == null) return 0;
        char[] cs = s.toCharArray();
        if (cs.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max= 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}