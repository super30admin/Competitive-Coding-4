class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    # Approach: Post-order DFS
    # Recursively check the height of left and right subtrees.
    # If the difference is more than 1 or if any subtree is already unbalanced (height = -1), return -1.
    # Return True if final height is not -1.
    # TC: O(n) - visit each node once
    # SC: O(h) - recursion stack, h = height of the tree
    def isBalanced(self, root):
        def height(node):
            if not node:
                return 0
            leftH = height(node.left)
            rightH = height(node.right)
            if leftH == -1 or rightH == -1 or abs(leftH - rightH) > 1:
                return -1
            return 1 + max(leftH, rightH)

        return height(root) != -1


if __name__ == "__main__":
    # Balanced Tree Example
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)

    sol = Solution()
    print("Is Balanced:", sol.isBalanced(root))  # Output: True
