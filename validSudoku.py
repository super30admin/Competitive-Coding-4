# TC: O(n^2)
# SC: O(n^2)

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if board is None:
            return False

        
        # check each row
        rMap = {}
        for r in range(9):
            rMap[r] = set()
            for c in range(9):
                if r in rMap:
                    if board[r][c] != ".":
                        if board[r][c] in rMap[r]:
                            return False
                        else:
                            rMap[r].add(board[r][c])
                        

        # check each column
        colMap = {}
        for c in range(9):
            colMap[c] = set()
            for r in range(9):
                if c in colMap:
                    if board[r][c] != ".":
                        if board[r][c] in colMap[c]:
                            return False
                        else:
                            colMap[c].add(board[r][c])  


        # add elements to grid
        gridMap = {}
        grid = 0
        for gridX in range(3):
            for gridY in range(3):
                for r in range(3*gridX, 3*gridX +3):
                    for c in range(3*gridY , 3*gridY + 3):
                        print(r,c)
                        if board[r][c] != ".":
                            if grid in gridMap:
                                if board[r][c] in gridMap[grid]:
                                    return False
                                else:
                                    gridMap[grid].add(board[r][c])
                            else:
                                gridMap[grid] = set()
                                gridMap[grid].add(board[r][c])
                grid += 1                    
        return True


