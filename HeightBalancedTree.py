#Time complexity: O(n)
#Space complexity: O(1)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    isValid=True
    def isBalanced(self, root) -> bool:
        self.isValid=True
        if not root:
            return True
        self.height(root)
        return self.isValid
        
          
    def height(self,root):
        if root is None:
            return 0
        l=self.height(root.left)+1
        r=self.height(root.right)+1
        if abs(l-r)>1:
            self.isValid=False
        return max(l,r)
        
        