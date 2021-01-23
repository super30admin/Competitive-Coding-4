# Created by Aashish Adhikari at 9:50 AM 1/22/2021
'''
Time Complexity:
O(m.n) since in the worst case when all the cells have fresh ranges except for the top-left cell, we append all the
cells to the bfs queue by the end and will have iterated through all of them at least once.

Space Complexity:
O(m.n) as all the cells will be added in the worst case to the bfs queue.
'''

class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """


        if len(grid) == 0:
            return 0

        from collections import deque

        q = deque()

        m = len(grid)
        n = len(grid[0])

        fresh_counter = 0
        for i in range(m):
            for j in range(n):

                if grid[i][j] == 2:
                    q.append((i,j))

                if grid[i][j] == 1:
                    fresh_counter += 1




        iteration = 0
        flag = False

        while len(q) != 0:

            flag = False
            rotten = len(q)

            for idx in range(rotten):


                # up
                if q[0] [0] - 1>= 0:

                    if grid [q[0] [0] - 1] [q[0][1]] == 1:
                        fresh_counter -= 1
                        # make rotten
                        grid [q[0] [0] - 1] [q[0][1]] = 2
                        #append to rotten queue
                        q.append( ( q[0] [0] - 1, q[0][1]) )
                        # note that a rotten orange added
                        flag = True



                # down
                if q[0][0] + 1 < m:

                    if grid[q[0][0] + 1] [q[0][1]] == 1:
                        fresh_counter -= 1
                        # make rotten
                        grid[q[0][0] + 1] [q[0][1]] = 2
                        q.append((q[0][0] + 1,q[0][1]))
                        flag = True


                # left
                if q[0][1] - 1 >= 0:

                    if grid[q[0][0]][q[0][1] - 1] == 1:
                        fresh_counter -= 1
                        grid[q[0][0]][q[0][1] - 1] = 2
                        q.append((q[0][0],q[0][1] - 1))
                        flag = True

                # right
                if q[0][1] + 1 < n:

                    if grid[q[0][0]][q[0][1] + 1] == 1:
                        fresh_counter -= 1
                        grid[q[0][0]][q[0][1] + 1] = 2
                        q.append((q[0][0],q[0][1] + 1))
                        flag = True

                q.popleft()

            if flag == True:
                iteration += 1


        if fresh_counter == 0:
            return iteration
        else:
            return -1










