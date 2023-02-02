package Problem6;

/* PROBLEM 6
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a 
 * given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *  P   A   H   N
 *  A P L S I I G
 *  Y   I   R
 *  
 *  And then read line by line: "PAHNAPLSIIGYIR"
 *  Write the code that will take a string and make this conversion given a number of rows:
 *
 */


class Problem6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String zig = "";
        int diff = (numRows - 1) * 2, j = 0, one = 0;
        for (int i = 0; i < numRows; i++) {
            j = i;
            while (j < s.length()) {
                if (diff != 0) {
                    zig+= s.charAt(j);
                    j+=diff;
                }
                if (one != 0 && j < s.length()) {
                    zig+= s.charAt(j);
                    j+=one;
                }
            }
            diff-=2;
            one+=2;
        }
        return zig;
    }
}