  # // Time Complexity : O(n)
# // Space Complexity : O(n), including recursive stack
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Yes, unsure about the time complexity and how to calculate it.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        
        #if no root, return true as it means it is balanced
        if not root:
            return True
        
        #get the height of left and right trees
        left = self.height(root.left)
        right = self.height(root.right)
        
        #if difference between their height is greater than one, they are unbalanced
        if abs(left-right)>1:
            return False
        
        #make recursive calls to make sure both sides are balanced from top to down
        return self.isBalanced(root.left) and self.isBalanced(root.right)
        
    def height(self, root:TreeNode):
        
        #no root, height of tree is zero
        if not root:
            return 0
        
        #return the maximum height betwwen left or right branch + 1 
        return max(self.height(root.left), self.height(root.right))+1
            
            
