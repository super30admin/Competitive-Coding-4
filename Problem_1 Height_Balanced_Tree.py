#Top Down Approach:
# // Time Complexity : O(nlogn)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def height(self, root: TreeNode):
        if not root:
            return 0
        return 1 + max(self.height(root.left), self.height(root.right))

    def isBalanced(self, root: TreeNode) -> bool:
        if not root:
            return True
        return abs(self.height(root.left) - self.height(root.right)) < 2 and self.isBalanced(
            root.left) and self.isBalanced(root.right)

#Bottom Up Approach :
# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:

    def isBalanced(self, root: TreeNode) -> bool:
        return self.helper(root)[0]

    def helper(self, root: TreeNode) -> (bool, int):
        if not root:
            return True, -1   #Empty Tree is balanced

        left_balance, left_height = self.helper(root.left)
        if not left_balance:
            return False, 0

        right_balance, right_height = self.helper(root.right)
        if not right_balance:
            return False, 0

        #If balanced, Check if current tree is balanced using height

        return (abs(left_height - right_height) < 2), 1 + max(left_height, right_height)


