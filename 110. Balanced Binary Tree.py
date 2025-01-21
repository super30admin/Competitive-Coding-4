#Time: O(n)
#Space: O(height of stack for recursion calls)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        balanced =self.inorder(root)
        return balanced[0]
    
    def inorder(self, root):
        if (root == None):
            return [True,0]
        
        left,right = self.inorder(root.left),self.inorder(root.right)
        balanced = left[0] and right[0] and (abs(right[1]-left[1]) <= 1)
        return [balanced , max(left[1],right[1]) + 1]

