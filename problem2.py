#balanced binary tree
# // Time Complexity :O(N)
# // Space Complexity : O(H) H=height of the tree
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



class Solution(object):
    def isBalanced(self, root):
        if root==None: return True
        self.balanced = True
        self.helper(root)
        return self.balanced
    
    def helper(self,root):
        if root==None: return 0             #if you get to the end, return 0 because the height is 0
        l=self.helper(root.left)
        r=self.helper(root.right)
        if(abs(l-r)>1):                     #if the difference between left and right values are more than 1, then its not balanced
            self.balanced=False 
        return 1+ max(l, r)                 #when you are returning back, you just add 1 to the max values of left and right to the height of the tree so far