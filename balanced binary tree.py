# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        #Approach: Recursive
        #Time Complexity: O(n)
        #Space Complexity: O(h) #under the hood
        
        self.isValid = True
        self.helper(root)
        return self.isValid
    
    def helper(self, root):
        #base
        if not root:
            return 0
        
        #logic
        leftHt = self.helper(root.left)
        rightHt = self.helper(root.right)
        
        if abs(leftHt - rightHt) > 1:
            self.isValid = False
        
        return 1 + max(leftHt, rightHt)