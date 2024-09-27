# Time Complexity : O(N) where N is number of nodes in the birnary tree
# Space Complexity : O(H) where h is height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root is None: return True

        return self.height(root)[0]
            
    def height(self, root):  
        if root is None:
            return [True, 0]
        else:
            left = self.height(root.left)
            right = self.height(root.right)
            
            isBalanced = left[0] and right[0] and abs(right[1] - left[1]) <= 1
            
            h = 1 + max(right[1], left[1])
            
            return [isBalanced, h]
        
        