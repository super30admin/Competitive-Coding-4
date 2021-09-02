# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    TC - O(n)
    SC - O(h)
    DFS APPROACH
    """
    def approach1(self, node):
        if node == None:
            return 0
        l, r = self.approach1(node.left), self.approach1(node.right)
        if l == -1 or r == -1 or abs(l - r) > 1:
            return -1
        return max(l, r) + 1

    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        return self.approach1(root) != -1

