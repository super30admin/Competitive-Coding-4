'''
Time Complexity: O(n)
Space Complexity: O(h) where h is the height of the tree due to recursion stack.

Approach: 
1. Use a recursive function to calculate the depth of each subtree.
2. If at any point the difference in depth between the left and right subtrees exceeds 1, return -1 to indicate imbalance.
3. If the difference in depth is less than or equal to 1, return 1 to indicate balance. 

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def depth(node):
            if not node:
                return 0

            leftDepth = depth(node.left)
            if leftDepth == -1:
                return -1

            rightDepth = depth(node.right)

            if rightDepth == -1:
                return -1

            if abs(leftDepth - rightDepth) > 1:
                return -1

            return max(leftDepth, rightDepth) + 1

        return depth(root) != -1