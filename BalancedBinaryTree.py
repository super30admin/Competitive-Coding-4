# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Brute force appoach: 
# T = O(n^2)

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        
        if abs(self.height(root.left) - self.height(root.right)) > 1:
            return False

        return self.isBalanced(root.left) and self.isBalanced(root.right)

    def height(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0

        left = self.height(root.left)
        right = self.height(root.right)

        return max(left, right) + 1


# Optimal appoach: 
# T = O(n)

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        
        if self.height(root) != -1:
            return True

        return False
        
        

    def height(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0

        left = self.height(root.left)
        right = self.height(root.right)

        if abs(left - right) > 1:
            return -1
        
        if (left == -1 or right == -1):
            return -1

        return max(left, right) + 1