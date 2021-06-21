"""
Approach: Recursively check for each node:
1) if the children and balanced
2) if the difference of their heights is 1 at max

TC: O(n logn)
SC: O(n)

"""
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if not root:
            return True

        left_stree = self.height(root.left)
        right_stree = self.height(root.right)

        if self.isBalanced(root.left) and self.isBalanced(root.right) and abs(left_stree - right_stree) < 2:
            return True
        else:
            return False


    def height(self, root):
        # base
        if not root:
            return 0
        # logic
        left_height = self.height(root.left)
        right_height = self.height(root.right)

        return 1 + max(left_height, right_height)