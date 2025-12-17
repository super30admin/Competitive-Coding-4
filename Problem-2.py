# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# We use post-order traversal to compute the height of left and right subtrees.
# At each node, we check if the height difference is greater than 1 to detect imbalance.
# If any subtree is unbalanced, we return -1 and propagate it upward; otherwise return height.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root) != -1
    def helper(self,root):
        if not root:
            return 0
        
        left = self.helper(root.left)
        if left == -1:
            return -1

        right = self.helper(root.right)
        if right == -1:
            return -1

        if abs(left-right)>1:
            return -1

        return max(left,right) + 1

        