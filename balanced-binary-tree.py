'''
TC: O(n)
SC: O(h) - height of the tree
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, node: Optional[TreeNode]) -> bool:
        
        def rec(root):
            if not root:
                return 0, True
            if not root.left and not root.right:
                return 1, True

            rh, rval, lh, lval = 0, True, 0, True

            if root.left:
                lh, lval = rec(root.left)
            if root.right:
                rh, rval = rec(root.right)


            return max(lh, rh) + 1, (lval and rval and (abs(rh - lh) <= 1))
    
        
        return rec(node)[1]
        