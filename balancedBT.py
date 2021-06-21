# Time Complexity : O(N) 
# Space Complexity :    O(H)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

class Solution:
    def __init__(self):
        self.flag = True
    def isBalanced(self, root: TreeNode) -> bool:
        if root==None:
            return True
        
        self.height(root)
        return self.flag
        
        
    
    def height(self,root):
        if root==None or self.flag==False:
            return 0
        
        #not height balanced
        
        case1 = self.height(root.left)
        case2 = self.height(root.right)
        
        if abs(case1-case2)<=1 :
             return 1+max(case1,case2)
        else:
            self.flag = False
            return -1
        