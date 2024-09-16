# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def helper(root):
            if root == None:
                return [0, True]
            case1 = helper(root.left)
            case2 = helper(root.right)
            h = 1 + max(case1[0],case2[0])
            if case1[1] == False or case2[1] == False:
                return [h, False]
            elif abs(case1[0] - case2[0]) > 1:
                return [h, False]
            return [h, True]

        if root == None:
            return True
        z = helper(root)
        return z[1]