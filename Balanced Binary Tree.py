# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        
        def helper(node):
            if not node:
                return 0
            
            L = helper(node.left)
            R = helper(node.right)
            
            if abs(L-R)>1 or L==-1 or R==-1:        # when you return -1 to upper nodes
                return -1
            
            return max(L,R) + 1
        
        return helper(root)!=-1