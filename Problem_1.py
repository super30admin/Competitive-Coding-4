# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if root == None:
            return True
        
        self.result = True
        self.helper(root)
        return self.result
 
    def helper(self, root: TreeNode) -> int:
        #base
        if root == None:
            return 0
        
        heightL = self.helper(root.left)    
        heightR = self.helper(root.right) 
                 
        if  abs(heightL - heightR) > 1:
            self.result = False
            return self.result 
        
        return max(heightL, heightR) + 1

# Bottom - up approach
# Time Complexity: O(n)
# Space Complexity: O(1)