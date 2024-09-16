# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    #Solution 1
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
    
    #Solution 2
    """
    def isBalanced(self, root: TreeNode) -> bool:
        #Approach: Recursive
        #Time Complexity: O(n)
        #Space Complexity: O(h) #under the hood
        
        return self.helper(root)[0]
    
    def helper(self, root):
        #base
        if not root:
            return True, -1
        
        leftBal, leftHt = self.helper(root.left)
        if not leftBal:
            return False, 0
        
        rightBal, rightHt = self.helper(root.right)
        if not rightBal:
            return False, 0
        
        return abs(leftHt - rightHt) <= 1, 1 + max(leftHt, rightHt)
    """