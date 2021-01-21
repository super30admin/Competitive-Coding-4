# Time Complexity : O(MN)
# Space Complexity : O(MN)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes. 


# Your code here along with comments explaining your approach
class Solution:
    
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        """
        GAVE TIME LIMIT EXCEEDED SO HAD TO OPTIMIZE--NEED CACHE
        TC: O(2 ^ (m+n))
        SC: O(MN)
        TC AND SC FOR UPDATED CODE AT THE BOTTOM IS AT THE TOP^^^^^
        """
    #     if not matrix:
    #         return 0
    #     ans = 0
    #     #dfs enter matrix 
    #     for i in range(len(matrix)):
    #         for j in range(len(matrix[0])):
    #             ans = max(ans, self.dfs(matrix, i, j))
        
    #     return ans
        
    # #dfs helper function
    # def dfs(self, matrix, i, j):
    #     #check boundaries
    #     ans = 0
    #     dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]        
    #     m = len(matrix)
    #     n = len(matrix[0])
    #     for direction in dirs:
    #         dy  = i + direction[0]
    #         dx = j + direction[1]
            
    #         #explore if valid
    #         if (dy >= 0 and dy < m and dx >= 0 and dx < n and matrix[dy][dx] > matrix[i][j]):
    #             ans = max(ans, self.dfs(matrix, dy, dx))
                
    #     return ans+1
        if not matrix:
            return 0
        ans = 0
        #create same size of matrix
        cache = [[1 for j in range(len(matrix[0]))] for i in range(len(matrix))]
        
        print(cache)
        #dfs enter matrix 
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                ans = max(ans, self.dfs(matrix, i, j, cache))
        
        return ans
        
    #dfs helper function
    def dfs(self, matrix, i, j, cache):
        #check boundaries
        #we've explored already
        if cache[i][j] != 1:
            return cache[i][j]
    
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]        
        m = len(matrix)
        n = len(matrix[0])
        for direction in dirs:
            dy  = i + direction[0]
            dx = j + direction[1]
            
            #explore if valid
            if (dy >= 0 and dy < m and dx >= 0 and dx < n and matrix[dy][dx] > matrix[i][j]):
                cache[i][j] = max(cache[i][j], self.dfs(matrix, dy,dx, cache)+1)
                #ans = max(ans, self.dfs(matrix, dy, dx))
                
        return cache[i][j]