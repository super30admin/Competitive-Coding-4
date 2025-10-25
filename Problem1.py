"""
TC: O(N) {Since we run across each and every node once}
sC: O(N) {The recursive stack space takes N nodes at worst when the tree is skewed}

Approach:
We use a standard int based dfs, where each node's left and right children return the max depth they have.
And based on the diff of those depths, we update the flag variable, which is when the depth differs by more than 1, we 
make the flag False and returns immediately.

The problem ran successfully on Leetcode
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def dfs(node)-> int:
            nonlocal flag
            #base case
            if not node:
                return 0
        
            #logic
            left = dfs(node.left)
            right = dfs(node.right)

            if abs(left - right) > 1:
                flag = False
                return 227

            return max(left, right) + 1
        
        if not root:
            return True

        flag = True
        res = dfs(root)
        return flag