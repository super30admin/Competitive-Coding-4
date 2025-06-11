# Definition for a binary tree node.
#Time Complexity: O(n^2)
#Space Complexity: O(h)
# Did this problem run in Leetcode: Yes
# Any problem you faced while coding this: No
# Your code here along with comments explaining your approach
# If a tree is height balanced then height difference between left and right node should be <= 1
# So I will recursively check left and right nodes if balanced and height diff is <= 1 
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def height(node):
            if node is None:
                return 0
            return max(height(node.left), height(node.right)) + 1
        if root is None:
            return True
        left_balanced = self.isBalanced(root.left)
        right_balanced = self.isBalanced(root.right)
        height_diff_ok = abs(height(root.left) - height(root.right)) <= 1

        return left_balanced and right_balanced and height_diff_ok