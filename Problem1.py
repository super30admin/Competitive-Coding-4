#Time complexity: O(n)
#Space complexity: O(h)

#Accepted on Leetcode

#Approach:
#Perform DFS, get height of LST and RST for each node and compare, if difference greater than one set global variable to false and return instantly


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    isValid = True
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.isValid = True
        self.dfs(root)
        return self.isValid
    

    def dfs(self,root):
        #If isValid is already false doesn't matter what we return -> return straightaway
        if self.isValid == False or root == None:
            return 0

        lh = self.dfs(root.left)
        rh = self.dfs(root.right)

        if abs(lh - rh) > 1:
            self.isValid = False
        
        return max(lh,rh) + 1

        