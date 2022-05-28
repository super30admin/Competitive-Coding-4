# Time Complexity : O(N) where N is number of nodes in the birnary tree
# Space Complexity : O(H) where h is height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.isBalanecedTree = True        
        
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
              
        self.isBalancedHelper(root)
        
        return self.isBalanecedTree
    
    def isBalancedHelper(self, root):
        #base
        if root is None or not self.isBalanecedTree:
            return 0
        
        #logic
        left = self.isBalancedHelper(root.left)
        right = self.isBalancedHelper(root.right)
        
        if abs(left - right) > 1:
            self.isBalanecedTree = False
            
        return 1 + max(left, right)