# Time Complexity : O(N) where N is the number of nodes in the linked list
# Space Complexity : O(h) where h is the height of the tree due to recursion stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I using a helper function to check the height of the tree.
# If the height difference between the left and right subtree is more than 1, we will return -1.
# If we encounter -1 at any point, we will return -1.
# If we reach the end of the tree without encountering -1, we will return the height of the tree.
# If the height is -1, we will return False, else we will return True.


from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def check(root):
            if not root:
                return 0
            lefty = check(root.left)
            righty = check(root.right)
            if lefty == -1 or righty == -1 or abs(lefty-righty) > 1:
                return -1
            return 1 + max(lefty,righty)
        return check(root)  != -1

        