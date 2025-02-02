// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(1), SC = O(1)
    public boolean isValidSudoku(char[][] board) {
        //valid board
        if(board == null || board.length != 9 || board[0].length != 9) return false;
        // row
        for(int i = 0; i < 9; i++) {
            boolean[] b = new boolean[9];
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(b[(int)(board[i][j] - '1')] == true) return false;
                    else b[(int)(board[i][j] - '1')] = true;
                }
            }
        }
        // column
        for(int j = 0; j < 9; j++) {
            boolean[] b = new boolean[9];
            for(int i = 0; i < 9; i++) {
                if(board[i][j] != '.') {
                    if(b[(int)(board[i][j] - '1')] == true) return false;
                    else b[(int)(board[i][j] - '1')] = true;
                }
            }
        }
        // block
        for(int block = 0; block < 9; block++) {
            boolean[] b = new boolean[9];
            // block 0 1 2 3 4 5 6 7 8
            // i (/) 0 0 0 1 1 1 2 2 2
            // j (%) 0 1 2 0 1 2 0 1 2 
            // this range + 3 helps to traverse each block
            for(int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) { 
                for(int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if(board[i][j] != '.') {
                        if(b[(int)(board[i][j] - '1')] == true) return false;
                        else b[(int)(board[i][j] - '1')] = true;
                    }
                }
            }
        }
        return true;
    }
}