'''
Balance Binary Tree
Time Complexity: O(nlogn)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: If the height of child at the left - height of the child at left is > 1 return False else iterate both left
and right nodes until we reach the leafs.
Height is computed as 1+max(root.left,root.right)
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def height(self, root: TreeNode) -> int:
        # better to give 0, it would go to both sides.
        if root == None:
            return 0
        return 1 + max(self.height(root.left), self.height(root.right))

    def isBalanced(self, root: TreeNode) -> bool:
        if root == None:
            return True

        if abs(self.height(root.left) - self.height(root.right) > 1):
            return False
        else:
            return self.isBalanced(root.left) and self.isBalanced(root.right)