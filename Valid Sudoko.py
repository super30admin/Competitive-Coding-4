#// Time Complexity : O(1) 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # Below approach is with defaultdict of sets
        rows=defaultdict(set)
        cols=defaultdict(set)
        square=defaultdict(set)

        for r in range(9):
            for c in range(9):

                if board[r][c]==".":
                    continue
                if (board[r][c] in rows[r] or board[r][c] in cols[c] or board[r][c] in square[(r//3,c//3)]):
                    return False

                rows[r].add(board[r][c])
                cols[c].add(board[r][c]) 
                square[(r//3,c//3)].add(board[r][c]) 
        return True

# Approach:
# 1. We will use a defaultdict of sets to store the elements in each row, column and
# 3x3 sub-grid. This will allow us to check if an element is present in
# a particular row, column or sub-grid in constant time.
# 2. We will iterate over each element in the board. If the element is '.', we will
# skip it as it is an empty cell.
# 3. If the element is not '.', we will check if it is present in the row, column
# or sub-grid. If it is present, we will return False as the board is not valid.
# 4. If the element is not present in the row, column or sub-grid, we will add
# it to the corresponding set.
# 5. If we have iterated over all elements in the board and haven't returned False,
# we will return True as the board is valid.
