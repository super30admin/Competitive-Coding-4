#Time Complexity :O(N)
#Space Complexity :O(H)
#Did this code successfully run on Leetcode :yes



# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
class Solution:
    def height(self, root):
        if root is None:
            return 0
        return max(self.height(root.left), self.height(root.right)) + 1

    def isBalanced(self, root: [TreeNode]) -> bool:
        if root is None:
            return True

        left_h = self.height(root.left)
        right_h = self.height(root.right)

        if (abs(left_h - right_h) <= 1) and self.isBalanced(root.left) and self.isBalanced(root.right):
            return True
        return False



                        
        