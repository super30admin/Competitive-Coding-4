"""
Approach:
we traverse the tree post-order and at each node we recursively Check 
if the left and right subtrees are balanced and calculate their heights.

Now we compare their heights to determine if current node is balanced or not.

Return True if the root is balanced.

T.C: O(n)

S.C: O(h)

Passed in leetcode : Yes
"""

# Definition for a binary tree node.

from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:

        def dfs(root):
            # Empty node is balanced and has height 0
            if not root:
                return [True, 0]

            # Recursively checking left and right subtrees
            left = dfs(root.left)
            right = dfs(root.right)

            #node is balanced if both left and right subtrees are balanced and the difference in their heights is no more than 1
            balanced = (left[0] and right[0] and abs(left[1] - right[1]) <= 1)

            return [balanced, 1 + max(left[1], right[1])]

        return dfs(root)[0]

sol = Solution()
node15 = TreeNode(15)
node7 = TreeNode(7)
node20 = TreeNode(20, node15, node7)
node9 = TreeNode(9)
root = TreeNode(3, node9, node20)
print(sol.isBalanced(root))