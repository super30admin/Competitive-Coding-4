'''
Time Complexty: O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        
        def dfs(root):
            if not root:
                return [True, 0]
            
            left=dfs(root.left)
            right=dfs(root.right)
            
            #should return true/false if all true and height
            balanced= abs(left[1]-right[1])<=1 and left[0] and right[0]
            
            return (balanced,1 + max(left[1],right[1]))
        
        return dfs(root)[0]