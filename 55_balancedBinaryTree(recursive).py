# Definition for a binary tree node.
# accepted in leetcode
# time - O(N)
# verify from leaf if the left and right subtrees are balanced or not(i.e., height difference is not more than one at any point) at everynode.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        # base case
        if not root: return True
        return self.isBalanced(root.left) and self.isBalanced(root.right) and abs(self.height(root.left)-self.height(root.right)) <= 1
    # method to determine the height at every node.
    def height(self,root):
        if not root: return 0
        return max(self.height(root.left),self.height(root.right))+1