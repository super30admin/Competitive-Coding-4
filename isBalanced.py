   def isBalanced(self, root: TreeNode) -> bool:
   #o(n) tc and sc(r-stack)
        if root==None :
            return True
        self.result=True
        self.helper(root, 0)
        
        return self.result
        
        
        
    def helper(self, root, level):
        if root ==None:
            return 0
        
        left=self.helper(root.left, level)
    
        right=self.helper(root.right, level)
        
        if abs(left-right)>1:
            self.result=False
        
        return max(left, right)+1
            
        
        
