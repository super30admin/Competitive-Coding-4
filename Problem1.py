# 1. Post order travels add to the count. If the count greater than 1 make the flag false.
# TC: O(N)
# SC: O(1)
# Yes, this worked in leetcode

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    Flag = True
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        self.recurse(root)
        return self.Flag

    def recurse(self, Node):
        if Node == None:
            return 0
        left = self.recurse(Node.left)
        right = self.recurse(Node.right)

        if abs(left - right) > 1:
            self.Flag = False
        return max(left, right) + 1
        

        
