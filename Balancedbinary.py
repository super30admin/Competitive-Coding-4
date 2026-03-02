# Time Complexity : O(n)
# Space Complexity : O(h) (h = height of tree)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use postorder traversal to compute height of left and right subtrees at each node.
# If height difference exceeds 1, mark tree as unbalanced; otherwise return subtree height upward.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:

        def helper(root):
            if root is None:
                return 0
            left = helper(root.left) + 1
            right = helper(root.right) + 1
            if abs(left - right) > 1:
                self.flag = False
                return -1
            return max(left,right)

        self.flag = True
        helper(root)
        return self.flag


        