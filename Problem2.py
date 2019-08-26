# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        # Time Complexity : O(n) where n is the number of elements in the tree
        # Space Complexity : constant because I'm not using any extra space.
        # base case
        if root == None:
            return True
        # finding the height of the left subtree and right subtree
        left_height = self.helper(root.left)
        right_height = self.helper(root.right)
        if abs(left_height - right_height) > 1:
            # the height difference between the left and right subtree must be less than or equal to 1
            return False
        return self.isBalanced(root.left) and self.isBalanced(root.right)

    def helper(self, root):
        # base case
        if root == None:
            return 0
        left = self.helper(root.left) + 1
        right = self.helper(root.right) + 1
        return max(left, right)