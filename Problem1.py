#Time Complexity :O(n)
#Space Complexity :O(h) h is the height of the tree
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if self.helper(root)>=0:
            return True
        else:
            return False

    def helper(self,root):
        if root==None:
            return 0
        left=self.helper(root.left)
        right=self.helper(root.right)
        if left<0 or right<0 or abs(left-right)>1:
            return -1
        return max(left,right)+1

        
