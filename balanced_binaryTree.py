'''
Executed in leetcode: Yes
Time complexity: O(n log n) in worst case (skewed tree)?
Space complexity: O(n)
Comments: Given below
Challenges: If not root, why is the height -1 not 0? I got incorrect answer with 0, and it worked with -1. Please comment.

'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:

        # Empty tree is balanced
        if not root:
            return True
        # If difference in height is more than or equal to 2, it is unbalanced
        if (abs(self.height(root.left) - self.height(root.right))>=2):
            return False
        else:
        # At this point, we know that either depth of left and right node is equal or differ by 1, so can use below code instead too
        # return (abs(self.height(root.left) - self.height(root.right))<2) and self.isBalanced(root.left) and self.isBalanced(root.right) 
        # We should check if individual subtrees are balanced too
            return self.isBalanced(root.left) and self.isBalanced(root.right)
        
    # Function for calculating height
    def height(self,root: TreeNode):
        if not root:
            return -1
        # Node itself constitutes the 1 here. Plus, the maximum depth/height among the child nodes
        return 1+max(self.height(root.left), self.height(root.right))
