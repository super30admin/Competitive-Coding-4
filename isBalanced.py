# // Time Complexity :O(N)
# // Space Complexity :O(h)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach
# use recursion to make problem smaller check at each and every node return height to parent 


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root:return True
        def helper(root):
            if not root:return 0
            lht=helper(root.left)
            if lht==-1:return -1
            rht=helper(root.right)
            if rht==-1:return -1
            if abs(lht-rht)>1:return -1
            return max(lht,rht)+1
        return helper(root)!=-1


        
