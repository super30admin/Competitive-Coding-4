// Time Complexity : O(n2)
// Space Complexity : O(9) so constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Check for rows hashset
//Check for columsn hashset
//Check for subgrids hashet
//Never returned false means true
import java.util.HashSet;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board==null || board.length==0){
            return false;
        }
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[][] subgrids = new HashSet[3][3];
        for(int i=0;i<9;i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                subgrids[i][j] = new HashSet<>();
            }
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char cell = board[i][j];
                if(cell == '.') continue;
                if(rows[i].contains(cell)) {
                    return false;
                }
                if(cols[j].contains(cell)) {
                    return false;
                }
                int subgridsrow = i/3;
                int subgridscol = j/3;
                if(subgrids[subgridsrow][subgridscol].contains(cell)){
                    return false;
                }
                rows[i].add(cell);
                cols[j].add(cell);
                subgrids[subgridsrow][subgridscol].add(cell);
            }
        }
        return true;
    }
}