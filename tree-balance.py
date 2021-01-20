# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        # bottom up recursion
        if(root==None) or (root.left==None and root.right==None):
            return True
        res = True
        def balance(root,depth):
            if(root==None):
                return depth
            d_left = balance(root.left,depth+1)
            d_right = balance(root.right,depth+1)
            if(abs(d_left-d_right)>1):
                nonlocal res 
                res= False
            return max(d_left,d_right)
        
        balance(root,0)
        return res
