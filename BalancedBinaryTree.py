# Time Complexity: O(N) where N is the height of the tree
# Space Complexity: O(1)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if root == None: return True
        return self.height(root) != -1
        
    def height(self, root: TreeNode) -> int:
        if root == None: return 0
        left = self.height(root.left)
        right = self.height(root.right)
        diff = abs(left - right)
        
        if diff > 1 or left==-1 or right==-1:
            return -1
        return (1 + max(left, right))