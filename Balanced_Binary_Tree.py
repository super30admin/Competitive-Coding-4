# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def isBalanced(self, root: TreeNode) -> bool:
        
        flag = True

        def helper(node=root):

            ### Base Case
            if not node:
                return 0

            ### Logic
            
            # Get the height of left and right sub tree
            left_height = helper(node.left)
            right_height = helper(node.right)

            # Validate the difference in heigh
            if abs(left_height - right_height) > 1:
                nonlocal flag
                flag = False

            # Return height to parent tree
            return max(left_height, right_height) + 1

        helper()
        return flag


### Complexity Analysis

# Time Complexity: O(N) --> Number of nodes in tree
# Space Complexity: O(H) --> Height of Tree [Recursive Stack]

