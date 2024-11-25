public class ValidSudoku{
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] columns = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        for(int i = 0; i < N; i++){
            rows[i] = new HashSet<Character>();
            columns[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                char curr = board[i][j];
                if(curr == '.') continue;
                int idx = (i/3)*3 + (j/3);
                if(rows[i].contains(curr) || columns[j].contains(curr) || boxes[idx].contains(curr)){
                    return false;
                }else{
                    rows[i].add(curr);
                    columns[j].add(curr);
                    boxes[idx].add(curr);
                }
            }
        }
        return true;
    }
}