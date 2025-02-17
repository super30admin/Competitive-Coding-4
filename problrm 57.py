# https://leetcode.com/problems/balanced-binary-tree/

# Time Complexity : O(n)
# Space Complexity : O(h) h = height of the tree
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        #helper(root)
        return self.helper(root) != -1 # if -1 is returned which means it is not heightbalanced and false else true

    def helper(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return 0

        left =  self.helper(root.left) # call left and if  -1 comes then simply return -1
        if left == -1:
            return -1

        right = self.helper(root.right) # same thing for right side as well
        if right == -1:
            return -1

        if abs(left - right) > 1: # if the diff is > 1 then return -1
            return -1

        return 1+max(left,right) # do 1+ max of left anf right subtree because we need to return the max depth to find the height difference
 
        