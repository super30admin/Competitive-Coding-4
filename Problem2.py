# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Balanced Binary Tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        return self.height(root) != -1
        
    def height(self, root: Optional[TreeNode]) -> int:
        # base case
        if root == None:
            return 0

        # logic
        left = self.height(root.left)
        right = self.height(root.right)
        if left == -1 or right == -1 or abs(left - right) > 1:
            return -1
        return max(left, right) + 1


    #     if root == None:
    #         return True

    #     if abs(self.height(root.left) - self.height(root.right)) > 1:
    #         return False
    #     # print(root.val, self.height(root))
    #     return self.isBalanced(root.left) and self.isBalanced(root.right)
        
    # def height(self, root:Optional[TreeNode]) -> int:
    #     # base
    #     if root == None:
    #         return 0
    #     # logic
    #     return max(self.height(root.left), self.height(root.right)) + 1

        