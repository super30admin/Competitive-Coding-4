#https://leetcode.com/problems/balanced-binary-tree/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if (root==None):
            return True
        
        def helper(node):
            #base
            if node==None:
                return -1
            leftHeight=helper(node.left)+1
            rightHeight=helper(node.right)+1
            if abs(leftHeight-rightHeight)>1:
                    
                    self.final=False
            return max(leftHeight,rightHeight)
                
        
        self.final=True
        helper(root)
        return self.final
        #time O(n)
        #Space O(n)
        
