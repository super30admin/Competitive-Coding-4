# Time Complexity: O(n logn), where n is the number of nodes in the tree
# Space Complexity: O(h), where h is the height of the tree
# Did this code successfully run on Leetcode: Yes

# Solution:

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if not root:
            return True

        # Recursively check if left and right subtree are balanced
        # And if the diff in height of left and right subtree is not more than 1

        return self.isBalanced(root.left) and self.isBalanced(root.right) and abs(
            self.height(root.left) - self.height(root.right)) <= 1

    def height(self, root: TreeNode) -> int:
        if not root:
            return 0
        return max(self.height(root.left), self.height(root.right)) + 1