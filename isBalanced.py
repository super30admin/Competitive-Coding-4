#Time Complexity: O(n)
#Space Complexity: O(h)
class Solution:
    isValid = True
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.isValid = True
        self.height(root)
        return self.isValid
    
    def height(self,root):
        if root == None:
            return 0
        
        l = self.height(root.left)+1
        
        r = self.height(root.right) + 1
        
        if abs(l-r) >1:
            self.isValid = False
            
        return max(l,r)
    
   