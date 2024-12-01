# // Time Complexity :O(n) for node traversal
# // Space Complexity :O(w) for tree max width
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
# Inititalize a queue, for every level order we compare with maximum, and reset max 
from collections import deque
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        if not root: return res
        q = deque()
        q.append(root)
    
        while q:
            maxi = float('-inf')
            n = len(q)
            for i in range(n):
                curr = q.popleft()
                if curr.val > maxi:
                    maxi = curr.val
                if curr.left:
                    q.append(curr.left)             # left child
                if curr.right:      
                    q.append(curr.right)            # right child
            res.append(maxi)     
        return res