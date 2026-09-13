# Time Complexity : O(n)
# Space Complexity : O(h) where h is the height of the tree (O(n) in worst case)
# Did this code successfully run on Leetcode : Yes
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return (self.dfs(root)>= 0)
    def dfs(self, root):
        if root is None:
            return 0
        leftheight = self.dfs(root.left)
        rightheight = self.dfs(root.right)
        if leftheight < 0  or rightheight < 0 or abs(leftheight - rightheight) > 1:
            return -1
        return 1 + max(leftheight, rightheight)
