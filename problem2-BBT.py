'''https://leetcode.com/problems/balanced-binary-tree/
'''


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right



# Time Complexity : O(N) true traversal in post order
# Space Complexity : O(N) (n/2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root is None: return True
        return self.balancedheight(root) != -1
    
    
    def balancedheight(self, root: TreeNode) -> int:
        '''postorder give height or -1 if imbalanced'''
        # base 
        if root is None: return 0
        
        # logic
        left_child_height = self.balancedheight(root.left)
        if left_child_height == -1:
            return -1
        right_child_height = self.balancedheight(root.right)
        if right_child_height == -1:
            return -1
        
        if abs(left_child_height-right_child_height) > 1: 
            return -1
                
        return 1+max(left_child_height, right_child_height)
    
    
        