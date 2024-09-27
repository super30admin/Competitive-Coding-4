# Time Complexity : O(N)
# Space Complexity : O(H) where H is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.result = None
        self.balanced = True
        
    def isBalanced(self, root: TreeNode) -> bool:
        
        result = self.helper(root)
        print(self.result)
        return self.balanced
        
        
    def helper(self, root):
        if root!=None:
            lh = self.helper(root.left)
            rh = self.helper(root.right)
            if abs(lh - rh) > 1 and self.result == None:
                self.result = root.val
                self.balanced = False
                
            h = 1+max(lh,rh)  
            return h
        else:
            return -1
        
        
        
                
                
                
            
        
        
    
        
        
        