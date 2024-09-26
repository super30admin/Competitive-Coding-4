# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        global flag
        flag = False

        def dfs(root):
            global flag
            if not root:
                return 0
            if flag: return 0

            left = 1 + dfs(root.left)
            right = 1 + dfs(root.right)

            if abs(left - right) > 1:
                flag = True
                # return -1

            return max(left, right)

        dfs(root)
        if flag == True:
            return False
        return True