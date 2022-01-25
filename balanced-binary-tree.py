# Time Complexity: O(n)
# Space Complexity: O(1)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    flag = False
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def helper(root):
            if not root: return 0
            case1 = helper(root.left)
            case2 = helper(root.right)
            if abs(case1-case2) > 1:
                self.flag = True
                return -1
            return 1 + max(case1, case2)
        
        helper(root)
        if self.flag:
            return False
        return True