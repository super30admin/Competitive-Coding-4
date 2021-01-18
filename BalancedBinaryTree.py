# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Recursion. Get the left subtree and right subtree height
# Then return if the left subtree is balanced and right subtree is balanced and absolute height of left subtree - right subtree <= 1
# else return False


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if not root:
            return True
        return self.isBalanced(root.left) and self.isBalanced(
            root.right
        ) and abs(self.height(root.left) - self.height(root.right)) <= 1

    def height(self, root):
        if not root:
            return 0

        left = self.height(root.left)
        right = self.height(root.right)

        return 1 + max(left, right)