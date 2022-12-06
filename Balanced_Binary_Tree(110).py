# Time Complexity: O(N)
# Space Complexity: O(h) height of tree(due to recursive call stack)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Here we use a bottom-up approach
# we go to the bottom node and return its height to its above node
# if we hit a null node we return 1 as height
# if at any point the differnce between height of left and right >1 it means that node is not balanced
# and we return False
# if at any point we encounter a False that means the tree is not balanced
# if after the execution the value of balanced is an integer it means that it was balanced at every node
# and never returned False => it is a balanced tree
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:

        def dfs(root):
            if root==None:
                return 1
            left = dfs(root.left)
            if left is False:
                return False
            right = dfs(root.right)
            if right is False or abs(left-right)>1:
                return False
            return max(left,right)+1

        balanced = dfs(root)
        if balanced is False:
            return False
        # if balanced==1 or balanced is not False:
        #     return True
        return True