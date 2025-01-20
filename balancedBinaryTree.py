# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        # TC : O(n) -- number of nodes
        # SC : O(h) -- height of tree
        def dfs(root,level):
            if root is None:
                return level
            # iterate to left and right sub trees
            lh = dfs(root.left,level+1)
            rh = dfs(root.right,level+1)
            # compare the heights of right and left sub trees
            if abs(lh-rh) >= 2:
                self.isValid = False
            return max(lh,rh)
        if root is None:
            return True
        self.isValid = True
        heightoftree = dfs(root,0)
        return self.isValid
        