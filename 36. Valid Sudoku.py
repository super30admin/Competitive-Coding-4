class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        cols = defaultdict(set)
        rows = defaultdict(set)
        sq = defaultdict(set)
        
        for r in range(9):
            for c in range(9):
                if board[r][c] == ".":
                    continue
                if (board[r][c] in rows[r] or #current value has any duplicate in row
                    board[r][c] in cols[c] or #current value has any duplicate in col
                    board[r][c] in sq[(r//3,c//3)]): #current value has any duplicate in subbox
                    return False
                cols[c].add(board[r][c])
                rows[r].add(board[r][c])
                sq[(r//3,c//3)].add(board[r][c])
        return True


#
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [{} for i in range(9)] # List of dict {num: index}
        cols = [{} for i in range(9)]
        subs = [{} for i in range(9)] # Mapping func: floor(rowNum / 3) * 3 + floor(colNum / 3)

        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    continue
                
                sub_index = floor(i / 3) * 3 + floor(j / 3)
                # floor(i / 3) * 3 + floor(j / 3)
                if board[i][j] in rows[i] or board[i][j] in cols[j] or board[i][j] in subs[sub_index]:
                    return False
                
                rows[i][board[i][j]] = ''
                cols[j][board[i][j]] = ''
                subs[sub_index][board[i][j]] = ''
        
        return True