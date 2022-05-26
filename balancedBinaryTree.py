'''
// Time Complexity : 0(n) -- end up traversing all the nodes
// Space Complexity : 0(h) -- recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def balancedBinaryTree(self,node):
        # base
        if node == None:
            return 0
        
        # logic
        
        # traversal -- go to the lhs
        h_lhs = self.balancedBinaryTree(node.left)
        
        # traversal -- go to the rhs
        h_rhs = self.balancedBinaryTree(node.right)
        
        # check balancedBinaryTree condition
        if (h_lhs != None and h_rhs != None) and (abs(h_lhs-h_rhs)<=1):
            return max(h_lhs,h_rhs)+1
        
        
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        if root == None:
            return True
        
        if isinstance(self.balancedBinaryTree(root), int):
            return True
        
        else:
            return False