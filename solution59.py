#Time Complexity:O(n)
#Space Complexity:O(1)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if not root:
            return True
        return self.isBalanced(root.left) and self.isBalanced(root.right) and abs(self.height(root.left)-self.height(root.right))<=1
        
    def height(self,root:TreeNode)->int:
        if not root:
            return 0
        return max([self.height(root.left),self.height(root.right)])+1

        #the is balanced function checks if the left and right subtrees are balanced and also calls the height function that counts the levels
        #of the trees. The return function checks if the heights difference of two subtrees are one or less.