#Competitive Coding-4 
#Problem2 : https://leetcode.com/problems/balanced-binary-tree/
#All test cases passed on Leetcode
#Time Complexity-O(N) 
#Space Complexity-O(N)
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
        return self.isBalanced(root.left) and self.isBalanced(root.right) and abs(self.height(root.left)-self.height(root.right))<=1
    
    def height(self,root):
        if root==None:
            return 0
        else:
            return max(self.height(root.left),self.height(root.right))+1