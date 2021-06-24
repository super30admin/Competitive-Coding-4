# Time Complexity : O(N)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#if height difference is greater than one then return -1 to keep track 
# if we get -1 from either of the left or right return -1 as the tree is unbalanced
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        return self.helper(root) != -1
    
    def helper(self,root):
        if root == None:
            return 0
        
        a = self.helper(root.left)
        
        if a==-1:
            return -1
        
        b = self.helper(root.right)
        
        if b == -1:
            return -1
        
        if abs(b-a)>1:
            return -1
        return 1+max(a,b)