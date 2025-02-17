# 110. Balanced Binary Tree

# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Intuition:
# Use a recursive function to check if the tree is balanced by checking the height of the left and right subtrees.
# If the difference in height is more than 1, the tree is not balanced.
# If the tree is balanced, return the height of the tree.
# If the tree is not balanced, return -1.

class Solution:
    def height(self, root):
        if root == None:
            return 0
        left = self.height(root.left)
        if left == -1:
            return -1

        right = self.height(root.right)
        if right == -1:
            return -1

        if abs(left - right) > 1: 
            return -1
            
        return 1 + max(left, right)

    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        return self.height(root) != -1
    
