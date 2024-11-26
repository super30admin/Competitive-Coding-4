# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        """
            https://leetcode.com/problems/balanced-binary-tree/
            // Time Complexity : O(n)
                        'n' is the number of nodes in the tree
            // Space Complexity : O(h)
                        'h' is the max height of the tree
            // Did this code successfully run on Leetcode : Yes
            // Any problem you faced while coding this : Yes with recursion
            // Three line explanation of solution in plain english :
                - For the recursion, check
                    - Whether its left and right subtrees are balanced
                    - Check if it is balanced including the root node
                      ( Diff height of left - height right <= 1)
                    - A None node has height -1
        """
        # edge case
        if root is None:
            return True
        return self._helper(root)[1]

    def _helper(self, root):

        # base case

        # an empty subtree is balanced and has a height of -1 as we define it
        # as a tree with one node will have height 0.
        # Left None (-1) + Right None (-1) = 0
        if root is None:
            return -1, True

        # logic

        # left sub tree
        left_height, isBalanced_left = self._helper(root.left)

        # left subtree is not balanced.
        # return immediately, no need to check further
        if not isBalanced_left:
            return left_height, isBalanced_left

        # right sub tree
        right_height, isBalanced_right = self._helper(root.right)
        # right subtree is not balanced
        if not isBalanced_right:
            return right_height, isBalanced_right

        # Our left and right subtrees are back and we have our results
        # 1) Check if the subtreesAreBalanced inlcuding this node
        # 2) Notate the height that this node sits at
        # (which is 1 plus the height of the larger of the left and right
        #  subtrees coming off of this node)
        subtrees_balanced = abs(left_height - right_height) <= 1
        height = max(left_height, right_height) + 1

        return height, subtrees_balanced
