# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Approach: DFS recurssive

# What we are doing in this apporach is basically asking if left subtree and right subtree are blanced binary tree or not. If they are not they return false else return the height of the subtrees.

# Time complexity: O(n); n = no of nodes
# Space complexity: O(h); where h = height of the tree

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if root == None:
            return True
        
        l = self.isBalanced(root.left)
        if not l:
            return False
        r = self.isBalanced(root.right)
        if not r: 
            return False
        
        if abs(l-r) > 1:
            return False
        else:
            return 1 + max(l,r)

        