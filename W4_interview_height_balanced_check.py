# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:

        self.result = True
        self.helper(root)
        return self.result

    def helper(self, root):
        # base
        if root == None:
            return 0
        
          # logic
            left = self.helper(root.left) + 1
            right = self.helper(root.right) + 1

        if abs(right - left) > 1:
            self.result = False
        
        return max(left, right)

# Time complexity: O(N), we visit each node once
# Space complexity: O(H), where h is the height of the tree. 

