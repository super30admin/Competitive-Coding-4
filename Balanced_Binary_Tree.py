###
# Approach:
# We use DFS (postorder) to check the balance and compute height at the same time.
# If any subtree is unbalanced, we return -1 early.
# At each node, we:
# - Check the left and right subtree heights.
# - If either subtree returns -1 or their height difference > 1, we propagate -1.
# - Otherwise, we return the height = 1 + max(left, right).
#
# Time Complexity: O(n), where n is the number of nodes (each visited once)
# Space Complexity: O(h), where h is the height of the tree (due to recursion stack)
###
class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isBalanced(self, root):
        def dfs(root):
            if not root:
                return 0
            left = dfs(root.left)
            if left == -1:
                return -1
            right = dfs(root.right)
            if right == -1:
                return -1
            if abs(left - right) > 1:
                return -1
            return 1 + max(left, right)
        return dfs(root) != -1
    
    def main(self):
        root1 = TreeNode(3)
        root1.left = TreeNode(9)
        root1.right = TreeNode(20, TreeNode(15), TreeNode(7))
        print("Is Balanced:", self.isBalanced(root1))  # Expected: True
        root2 = TreeNode(1)
        root2.left = TreeNode(2)
        root2.right = TreeNode(2)
        root2.left.left = TreeNode(3)
        root2.left.right = TreeNode(3)
        root2.left.left.left = TreeNode(4)
        root2.left.left.right = TreeNode(4)
        print("Is Balanced:", self.isBalanced(root2))  # Expected: False

sol = Solution()
sol.main()