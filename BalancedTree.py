#Time Complexity : O(nlogn) where n is number of elements in list
#Space Complexity :  O(n)

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Find height of left and right subtree and keep comparing node's children's height, if anywhere the difference in height is more than 2 then we need to return False. This way check all nodes's children of the tree.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getHeight(self, root):
            if not root:
                return 0
            return max(self.getHeight(root.left), self.getHeight(root.right)) + 1

    def isBalanced(self, root: TreeNode) -> bool:
        if not root:
            return True
        return abs(self.getHeight(root.left) - self.getHeight(root.right)) < 2 and self.isBalanced(root.left) and self.isBalanced(root.right)
