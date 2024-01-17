class Solution:
    def isBalanced(self, root):
        return (self.Height(root) >= 0)
    def Height(self, root):
        if root is None:
            return 0
        leftheight = self.Height(root.left)
        rightheight = self.Height(root.right)
        if leftheight < 0 or rightheight < 0 or abs(leftheight - rightheight) > 1:
            return -1
        return max(leftheight, rightheight) + 1
# Time complexity : O(N)
# Space complexity : O(1)
