# T.C - O(n)
# S.C - O(1)
# Here we started the solution by using Bottom-Up appraoch and collectively we also have been
# calculating the height at each node and seeing a difference between right subtree and left subtree 
# 
# We could have solved it by using O(n^2) by Top-down running dfs on left subtree and running dfs on right subtree
# 


from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def depthFS(root):
            if not root:
                return [True, 0]
            left, right = depthFS(root.left), depthFS(root.right)
            balanced = (left[0] and right[0] and abs(left[1] - right[1]) <= 1)
            return [balanced, 1 + max(left[1], right[1])]

        return depthFS(root)[0]

# Helper function to construct a binary tree from a list
def buildTreeFromList(lst):
    if not lst:
        return None
    nodes = [TreeNode(val) if val is not None else None for val in lst]
    kids = nodes[::-1]
    root = kids.pop()
    
    for node in nodes:
        if node:
            if kids: node.left = kids.pop()
            if kids: node.right = kids.pop()
    
    return root

# Construct the tree from list input
tree_root = buildTreeFromList([3,9,20,None,None,15,7])

# Create a Solution object and check if the tree is balanced
sol = Solution()
print(sol.isBalanced(tree_root))  # Output: True

