# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        """
        Recursively check each node if it's within valid height range..
        recursion will go all the way to bottom left and work its way up passing values (valid or not)
        along the way
        """
        def helper(root):
            if not root:
                return 0

            leftTree = helper(root.left)
            rightTree = helper(root.right)

            if leftTree == -1 or rightTree == -1 or abs(leftTree- rightTree) > 1:
                return -1 

            return max(leftTree, rightTree) + 1

        return helper(root) != -1