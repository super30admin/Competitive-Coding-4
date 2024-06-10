# TC - O(N)
# SC - O(N)

# Approach -

# follow bottom to top approach
# calculate the height and isBalanced for each node from the leaf nodes to the root of the tree


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:

        isBalanced, heightDiff = self.checkTree(root)

        return isBalanced

    def checkTree(self, root):

        if root is None:
            return [True, 0]

        isBalancedLeft, leftHeight = self.checkTree(root.left)
        isBalancedRight, rightHeight = self.checkTree(root.right)

        if isBalancedLeft == False or isBalancedRight == False:
            return [False, -1]

        heightDiff = abs(leftHeight-rightHeight)

        if heightDiff <= 1:
            heightDiff = True
        else:
            heightDiff = False

        return [heightDiff, 1 + max(leftHeight, rightHeight)]
