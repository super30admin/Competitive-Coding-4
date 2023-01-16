# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No
class Solution(object):
    def __init__(self):
        self.flag=True
    
    def rec(self,root):
        if(root==None):
            return 0
        if(self.flag):
            l=self.rec(root.left)
            r=self.rec(root.right)
        else:
            return 100000

        if(abs(l-r)>1):
            self.flag=False
        return (max(l,r)+1)

    def isBalanced(self, root):
        self.rec(root)
        return(self.flag)