package Problem7;

/* PROBLEM 7
 * 
 * Given a signed 32-bit integer x, return x with its digits reversed. 
 * 
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], 
 * then return 0.
 * 
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 */


class Problem7 {
    public int reverse(int x) {
        int temp = Math.abs(x), num = 0, mul = 0;
        while(temp > 0) {
            int var = temp;
            while (var >= 10) {
                var/=10;
                mul++;
            }
            num += (temp % 10) * Math.pow(10, mul);
            if (num == Integer.MAX_VALUE) {
                return 0;
            }
            temp/=10;
            mul = 0;
            
        }
        if(num < Integer.MIN_VALUE || num > Integer.MAX_VALUE) {
            return 0;
        }
        if(x < 0) {
            return -1 * num;
        }
        return num;
    }
}

/* LEET CODE
 * 
class Solution {
	public int reverse(int x) {
	    int rev = 0;
	    while (x != 0) {
	        int pop = x % 10;
	        x /= 10;
	        if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
	        if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
	        rev = rev * 10 + pop;
	    }
	    return rev;
	}
}
*/