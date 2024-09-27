class Solution:
    def isBalanced(self, root) -> bool:
        # If root is null, then return True
        if not root:
            return True

        # Check if the difference between the heights of left and right subtrees is less than 2 or not
        return abs(self.getHeight(root.left) - self.getHeight(root.right)) < 2 and self.isBalanced(
            root.left) and self.isBalanced(root.right)

    # Helper function to get the height of a node
    def getHeight(self, root):
        if not root:
            return 0
        return 1 + max(self.getHeight(root.left), self.getHeight(root.right))