# Time Complexity :
# O(N)

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :
#Yes

#We compute the depth of each subtree recursively. We then compare the depth of left and right subtree - if the difference is more than one, we set the flag to false
#We return the flag in the end

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None :
            return True
        self.flag = True
        depth = self.get_subtree_depth(root)
        return self.flag

    def get_subtree_depth(self,root):
        if root == None:
            return 0

        depth1 = self.get_subtree_depth(root.left)
        depth2 = self.get_subtree_depth(root.right)
               
        if abs(depth1 - depth2) > 1 :
            self.flag = False

        return max(depth1,depth2) + 1

        
