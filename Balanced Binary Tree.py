#Time: O(n)
#space: O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    maxl=0
    def isBalanced(self, root: TreeNode) -> bool:
        if (root==None):
            return True
        maxl=self.dfs(root.left)
        maxr=self.dfs(root.right)
        return self.isBalanced(root.left) and self.isBalanced(root.right) and abs(maxr-maxl)<=1 
    
    def dfs(self,root):
        if(root==None):
            return 0
        return max(self.dfs(root.right),self.dfs(root.left))+1
        