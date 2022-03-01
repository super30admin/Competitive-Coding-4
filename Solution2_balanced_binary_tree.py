// Time Complexity : O(nlogn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def calulate_height(self,node):
        if not node:
            return 0
        else:
            return 1 + max(self.calulate_height(node.left),self.calulate_height(node.right))
        
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root ==None:
            return True
        else:
            return abs(self.calulate_height(root.left)-self.calulate_height(root.right)) <=1                    and self.isBalanced(root.left) and self.isBalanced(root.right)
        