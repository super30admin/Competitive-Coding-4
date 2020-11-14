# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No (referred to solution)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        
        if root==None:
            return True
        
        def height(nd:TreeNode):
            if nd==None:
                return 0
            return max(height(nd.left), height(nd.right))+1
                
            
        return self.isBalanced(root.left) and self.isBalanced(root.right) and abs(height(root.left)-height(root.right))<=1
    
        
        