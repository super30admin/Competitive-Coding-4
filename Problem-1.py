#Time Complexity :o(n)
#Space Complexity :o(h) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if(root==None):
            return True
        
        ans=self.helper(root)
        if(ans==-1):
            return False
        return True
    
    def helper(self,root):
        #base
        if(root==None):
            return 0
        #logic
        left=self.helper(root.left)
        right=self.helper(root.right)
        
        if(left==-1 or right==-1 or abs(left-right)>1):
            return -1
        return max(left,right)+1
        