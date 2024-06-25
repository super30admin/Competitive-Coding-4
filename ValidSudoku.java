class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++) {
            boolean[] rowcheck = new boolean[9];
            boolean[] colcheck = new boolean[9];
            for(int j = 0; j < n; j++) {    
                if(board[i][j] != '.') {
                  if(rowcheck[(int)(board[i][j] - '1')]) { // if true then return false
                    return false;
                  } else {
                    rowcheck[(int)(board[i][j] - '1')] = true;
                  }    
                }           
                if(board[j][i] != '.') {
                  if(colcheck[(int)(board[j][i] - '1')]) { // if true then return false
                    return false;
                  } else {
                    colcheck[(int)(board[j][i] - '1')] = true;
                  }    
                }          
            }
        }

        // grid check
        for(int k = 0; k < 9; k++) {
            boolean[] boardcheck = new boolean[9];
            for(int i = (k / 3) * 3 ; i < (k / 3 * 3) + 3; i++) {
                for(int j = (k % 3) * 3; j < (k % 3 * 3) + 3; j++) {
                    if(board[i][j] != '.') {
                        if(boardcheck[(int)(board[i][j] - '1')]) {
                            return false;
                        } else {
                            boardcheck[(int)(board[i][j] - '1')] = true;
                        }    
                    }
                }
            }
        }
        return true;
    }
}
