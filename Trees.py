# Time Complexity :O(n^2)
# Space Complexity :O(n^2)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    #calculate hight function
    def getmaxhight(self,root,hight):
        if not root:
            return hight
        return max(self.getmaxhight(root.left,hight+1), self.getmaxhight(root.right,hight+1))
        
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        #edge case
        if not root: return True
        #get hight left and right
        highleft = self.getmaxhight(root.left,1)
        highright = self.getmaxhight(root.right,1)
        #if hight diff is more than one return false
        if abs(highleft-highright) >1:
            return False
        #return is balanced left and right
        return (self.isBalanced(root.left) and self.isBalanced(root.right))