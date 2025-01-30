#Time Complexity = O(n)
#Space Complexity = O(n)
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        N = 9
        # Use hash sets to track seen numbers
        rows = [set() for i in range(N)]
        cols = [set() for i in range(N)]
        boxes = [set() for i in range(N)]

        for r in range(N):
            for c in range(N):
                val = board[r][c]

                # Skip empty cells
                if val == '.':
                    continue

                # Check row
                if val in rows[r]:
                    return False
                rows[r].add(val)

                # Check column
                if val in cols[c]:
                    return False
                cols[c].add(val)

                # Check 3x3 box
                idx = (r // 3) * 3 + (c // 3)
                if val in boxes[idx]:
                    return False
                boxes[idx].add(val)

        return True
