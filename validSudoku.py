# // Time Complexity :O(1)-> O(81)
# // Space Complexity :O(1)-> O(27)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# // Your code here along with comments explaining your approach

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        m = len(board)
        n = len(board[0])

        # if m != 9 or n != 9: return False 
        row = {}            # since 9 elements in to find in row,col and sub-block
        col = {}            # total 27 to compare    
        sub = {}            # we use hashset

        for i in range(m):                      #1 pass 
            for j in range(n):
                curr = board[i][j]
                if curr != ".":
                    curr = int(curr)    #board(3,5) = 6         #str -> int
                    if i not in row:       
                        row[i] = set()  # row[0]                #if row[i] not in hashset, we add it
                    if j not in col:
                        col[j] = set()  # col[4] 

                    subRC = (i//3,j//3) # sub[(0,4)]S
                    if subRC not in sub:
                        sub[subRC] = set()

                    if curr in row[i] or curr in col[j] or curr in sub[subRC]:
                        return False
                
                    row[i].add(curr)    # row[3] = 6
                    col[j].add(curr)    # col[5] = 6
                    sub[subRC].add(curr)# sub[(1,1)] = [1,6]
        return True