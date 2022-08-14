# Time complexity : O(n)
# Space complexity : O(h)
# Leetcode : Solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        # checking if we have an empty tree or tree with one node, then it is balanced
        if root is None or (root.left is None and root.right is None):
            return True
        
        # calculate the height of left and right subtree by calling the helper function
        height_left = self.height(root.left)
        height_right = self.height(root.right)
        
        # if difference in height is greater than 1, it is not balanced
        if abs(height_left - height_right) > 1:
            return False
        
        # recursiely call the left and right subtree to check if the subtrees are balanced or not
        return self.isBalanced(root.left) and self.isBalanced(root.right)
        
    # helper function to calculate the height of the given tree
    def height(self, root):
        if root is None:
            return 0
        # height is maximum of left or right subtree plus the root
        return 1 + max(self.height(root.left), self.height(root.right))
