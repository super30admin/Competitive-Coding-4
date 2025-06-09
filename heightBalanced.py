"""
Using post-order traversal to find height of left and right subtrees
If height difference > 1, mark the tree as unbalanced.
Return both height and balance status up the recursive call.
"""
"""
Time Complexity: O(n) — All nodes visited once
Space Complexity: O(h) — Recursion stack
"""
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class heightBalanced:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def check(node):
            if not node:
                return 0  

            left = check(node.left)
            if left == -1:
                return -1

            right = check(node.right)
            if right == -1:
                return -1

            if abs(left - right) > 1:
                return -1  

            return 1 + max(left, right)

        return check(root) != -1
    
if __name__=="__main__":

    root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right.left = TreeNode(15)
    root.right.right = TreeNode(7)

    obj = heightBalanced()
    print(obj.isBalanced(root))

