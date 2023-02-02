package Problem37;

/* PROBLEM 37
 * 
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

 

Example 1:


Input: 
board = [["5","3",".",".","7",".",".",".","."],
		["6",".",".","1","9","5",".",".","."],
		[".","9","8",".",".",".",".","6","."],
		["8",".",".",".","6",".",".",".","3"],
		["4",".",".","8",".","3",".",".","1"],
		["7",".",".",".","2",".",".",".","6"],
		[".","6",".",".",".",".","2","8","."],
		[".",".",".","4","1","9",".",".","5"],
		[".",".",".",".","8",".",".","7","9"]]
		
Output: [["5","3","4","6","7","8","9","1","2"],
		["6","7","2","1","9","5","3","4","8"],
		["1","9","8","3","4","2","5","6","7"],
		["8","5","9","7","6","1","4","2","3"],
		["4","2","6","8","5","3","7","9","1"],
		["7","1","3","9","2","4","8","5","6"],
		["9","6","1","5","3","7","2","8","4"],
		["2","8","7","4","1","9","6","3","5"],
		["3","4","5","2","8","6","1","7","9"]]
	Explanation: The input board is shown above and the only valid solution is shown below:


 */


class Problem37 {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    
    private boolean solve(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.' ) {
                    for(char c = '1'; c <= '9'; c++) {
                        if(isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if(solve(board)) return true;
                            else board[i][j] = '.';
                        }
                
                    }
                    
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValid(char[][] board, int i, int j, char ch) {
        for(int r = 0; r < 9; r++) {
            if(board[r][j] == ch) return false;
        }
        
        for(int c = 0; c < 9; c++) {
            if(board[i][c] == ch) return false;
        }
        
        for(int r = (i / 3) * 3; r < (i / 3) * 3 + 3; r++) {
            for(int c = (j / 3) * 3; c < (j / 3) * 3 + 3; c++) {
                if(board[r][c] == ch) return false;
            }
        }
        
        return true;
    }
}