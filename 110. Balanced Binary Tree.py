"""
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
    """
    Run time omplexity: O(N log K)
    Space Complexity: O(N)
    
    
    Traverse through elements and find the difference is 1 or less.
    """
        if not root:
            return True
        
        def helper(root):
            if not root:
                return -1
            if root:
                return 1 + max(helper(root.left), helper(root.right))
        
        return abs(helper(root.left) - helper(root.right)) < 2 and self.isBalanced(root.left) and self.isBalanced(root.right)
        
            