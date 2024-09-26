"""
FAANMG Problem #60 {Easy }

110. Balanced Binary Tree

Time Complexity : O(N)


Space Complexity : O(h)


Did this code successfully run on Leetcode : Yes
  

 

@name: Rahul Govindkumar_RN27JUL2022
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def height_DFS(self,root):
        
        #base
        if(root is None):
            return 0
        
        #logic
        left = self.height_DFS(root.left)
        right = self.height_DFS(root.right)
        
        if( abs(left -right) > 1):
            return -1
        
        if(left == -1 or right ==-1):
            return -1
        
        return 1 + max(left,right)
        
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
    
        
        if(self.height_DFS(root) != -1):
            return True
        else:
            return False
        
        
"""
FAANMG Problem #60 {Easy }

110. Balanced Binary Tree

Time Complexity : O(N)


Space Complexity : O(h)


Did this code successfully run on Leetcode : Yes
  

 

@name: Rahul Govindkumar_RN27JUL2022
"""
        
 
    
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def height_DFS(self,root):
        
        #base
        if(root is None):
            return 0
        
        #logic
        left = self.height_DFS(root.left)
        right = self.height_DFS(root.right)
        
        #Return false if the difference is greater than 1 meaning its unbalanced
        if( abs(left -right) > 1):
            self.balance = False
        
        return 1 + max(left,right)
        
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        

        
        self.balance = True
        
        self.height_DFS(root)
        
        return self.balance
        
        