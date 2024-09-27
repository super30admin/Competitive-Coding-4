#Time complexity is: O(n)
#Space complexity is: O(h)
#COde ran successfully on leetcode
#No problem faced while coding this program

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if(root==None):
            return True
        #We will return boolean value based on the return value from height method
        return self.height(root)!=-1

    #We are going to go from child to parent
    def height(self,root):
        if(root==None):
            return 0
        #Finding the height of the left and right sub trees
        left=self.height(root.left)
        right=self.height(root.right)
        #If the absolute difference between left and right is greater than 1, we will return -1
        if(abs(left-right)>1):
            return -1
        #if the left and right vlaue is equal to -1, we will return 1
        if(left==-1 or right==-1):
            return -1
        #else we will return 1 + maximum of left and right
        return max(left,right)+1