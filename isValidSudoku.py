from collections import defaultdict
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # Sets to store seen numbers for rows, columns, and 3x3 squares
        rows = defaultdict(set)
        cols = defaultdict(set)
        square = defaultdict(set)
        
        # Iterate over every cell in the board
        for row in range(len(board)):
            for col in range(len(board[0])):
                # Skip empty cells
                if board[row][col] == ".":
                    continue
                
                # Check if the number is already seen in the row, column, or 3x3 square
                if (board[row][col] in rows[row] or 
                    board[row][col] in cols[col] or 
                    board[row][col] in square[(row // 3, col // 3)]):
                    return False
                
                # Add the number to the corresponding row, column, and 3x3 square sets
                rows[row].add(board[row][col])
                cols[col].add(board[row][col])
                square[(row // 3, col // 3)].add(board[row][col])
        
        # If no conflicts are found, the Sudoku is valid
        return True

# Time Complexity: O(1)
# - The board is always 9x9, so the algorithm performs a constant amount of work.
# - Specifically, it checks each of the 81 cells a fixed number of times.

# Space Complexity: O(1)
# - The additional space used by the sets is bounded by the fixed size of the board (9 rows, 9 columns, and 9 3x3 squares).
# - Each set can contain at most 9 unique elements (digits 1-9), leading to constant space usage.
