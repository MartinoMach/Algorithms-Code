package Problem8;

/* PROBLEM 8
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit 
 * signed integer (similar to C/C++'s atoi function).
 * 
 * The algorithm for myAtoi(string s) is as follows: Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'.
 * 
 * Read this character in if it is either. 
 * 
 * This determines if the final result is negative or positive respectively. 
 * 
 * Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached. 
 * 
 * The rest of the string is ignored.
 * 
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). 
 * 
 * If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * 
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the
 * integer so that it remains in the range. 
 * 
 * Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 
 * should be clamped to 231 - 1.Return the integer as the final result.
 * 
 */


class Problem8 {
	  public int myAtoi(String str) {
	    
	    final int len = str.length();
	    
	    if (len == 0){
	        return 0;
	    }
	    
	    int index = 0;
	    
	    // skipping white spaces
	    while (index < len && str.charAt(index) == ' '){
	        ++index;
	    }
	    
	    boolean isNegative = false;
	    
	    // to handle sign cases
	    if (index < len) {
	      
	      if (str.charAt(index) == '-') {
	        isNegative = true;
	        ++index;
	      } else if (str.charAt(index) == '+'){
	          ++index;
	      }
	      
	    }
	    
	    int result = 0;
	    
	    // converting digit(in character form) to integer form
	    // iterate until non-digit character is not found or we can say iterate till found character is a digit
	    while (index < len && isDigit(str.charAt(index))) {
	      
	      /* str.charAt(index) - '0' is to convert the char digit into int digit eg: '5' - '0' --> 5
	      or else it will store the ASCII value of 5 i.e. 53,
	      so we do 53(ASCII of 5) - 48(ASCII of 0(zero)) to get 5 as int*/
	      int digit = str.charAt(index) - '0';
	      
	      // to avoid integer overflow
	      if (result > (Integer.MAX_VALUE / 10) || (result == (Integer.MAX_VALUE / 10) && digit > 7)){
	          return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
	      }
	      
	      // adding digits at their desired place-value
	      result = (result * 10) + digit;
	      
	      ++index;
	    }
	      
	    return isNegative ? -result : result;
	  }
	  
	  private boolean isDigit(char ch) {
	    return ch >= '0' && ch <= '9';
	  }
	}
