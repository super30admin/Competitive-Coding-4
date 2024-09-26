# Time Complexity: O(n)
# Space Complexity: O(h) where h is the height of the tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def height(self,root):
        if not root:
            return 0
        l = self.height(root.left)
        r = self.height(root.right)
        
        if(abs(l-r) > 1):
            return -1
        if(l==-1 or r==-1):
            return -1
        
        return 1+max(l,r)
    
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if self.height(root)==-1:
            return False
        return True