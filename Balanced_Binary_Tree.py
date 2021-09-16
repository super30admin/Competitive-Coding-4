# Time Complexity: O(n)
# Space Complexity: O(1)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        def helper(node):                               # Use helper function to recursively call
            if not node:
                return(0, True)
            
            l_height, l_balance = helper(node.left)     # helper function on left node
            r_height, r_balance = helper(node.right)    # helper function on right node
            
            return (max(l_height, r_height), l_balance and r_balance and abs(l_height - r_height) <= 1)
        
        return helper(root)[-1]                         # Calling helper function on root
        