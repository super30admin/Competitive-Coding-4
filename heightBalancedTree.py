# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root) -> bool:
        if root == None:
            return True
        def recursion(root):
            if root == None:
                return 0
            case1 = recursion(root.left)
            case2 = recursion(root.right)
            if  abs(case1-case2) >= 2:
                self.res = False
            return max(case1, case2) + 1

        self.res = True
        recursion(root)  
        return self.res
    
#TC: O(n)
#SC: O(n)