#Time Complexity = O(n)
#Space Complexity = O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import sys
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        res = []
        q = deque([root])
        while q:
            levelSize = len(q)
            maxValue = float('-inf')
            for i in range(levelSize):
                node = q.popleft()
                maxValue = max(maxValue,node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            res.append(maxValue)
        return res
            
