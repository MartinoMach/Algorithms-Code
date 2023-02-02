package Problem43;



/* PROBLEM 43
 * 
 
 Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

	Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
	
	 
	
	Example 1:
	
	Input: num1 = "2", num2 = "3"
	Output: "6"
	Example 2:
	
	Input: num1 = "123", num2 = "456"
	Output: "56088"

 */


class Solution {
    public String multiply(String num1, String num2) {
        if(isZero(num1) || isZero(num2)) return "0";
        if(isOne(num1)) return num2;
        if(isOne(num2)) return num1;

        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int[] ans = new int[c1.length + c2.length];

        for(int i = c1.length - 1; i >= 0; i--) {
            int c = c1[i] - '0';
            for(int j = c2.length - 1; j >= 0; j--) {
                ans[i + j + 1] += c * (c2[j] - '0');
            }
        }

        for(int i = ans.length - 1; i > 0; i--) {
            if(ans[i] > 9) {
                ans[i - 1] += ans[i] / 10;
                ans[i] %= 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;

        for(; ; i++) if(ans[i] != 0) break;

        for(; i < ans.length; i++) {
            sb.append((char) (ans[i] + '0'));
        }

        return sb.toString();
    }

    private int toNum(char c) {
        return Character.getNumericValue(c);
    }
    
    private boolean isZero(String num) {
        return num.equals("0");
    }

    private boolean isOne(String num) {
        return num.equals("1");
    }
}