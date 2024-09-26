# // Time Complexity : O(n)
# // Space Complexity : O(h)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
 # 1.DFS at every node
 # 2.check if the rule satisfies for the all the nodes
 # 3.recurse

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    Flag = True
    def helper(self,root):
        if root == None:
            return 1
        if self.Flag == False:
            return -1
        leftlength = self.helper(root.left)
        
        
        rightlength = self.helper(root.right)
        
        if abs(rightlength - leftlength) < 2:
            return (1 + max(rightlength,leftlength))
        else:
            self.Flag = False
        return 0
    def isBalanced(self, root: TreeNode) -> bool:
        
        if root == None:
            return True
        self.helper(root)
        return(self.Flag)