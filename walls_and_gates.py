'''
Time complexity: O(n*m)
Space complexity: O(n)
'''
from collections import deque
class Solution:
    """
    @param rooms: m x n 2D grid
    @return: nothing
    """
    def wallsAndGates(self, rooms):
        # write your code here
    
        n = len(rooms)
        m = len(rooms[0])
        queue = deque()
        
        for i in range(n):
            for j in range(m):
                if rooms[i][j] == 0:
                    print(i,j)
                    queue.append([i,j])
        
        level = 0
        visited = set()
        dirs = [[-1,0], [1,0], [0,1], [0,-1]]
        
        while queue:
            for i in range(len(queue)):
                row, col = queue.popleft()
                if level > 0:
                    rooms[row][col] = level
                for dir in dirs:
                    x = row + dir[0]
                    y = col + dir[1]
                    if x >= 0 and x < len(rooms) and y >= 0 and y < len(rooms[0]) and rooms[x][y] != 0 and rooms[x][y] != -1 and (x,y) not in visited:
                        queue.append([x,y])
                        visited.add((x,y))
            level = level + 1