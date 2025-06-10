# Time Complexity: O(n)
# Space Complexity: O(h)

class Solution:
    def isBalanced(self, root):
        def isBalancedHelper(node):
            if node is None:
                return 0
            left = isBalancedHelper(node.left)
            right = isBalancedHelper(node.right)
            if left == -1 or right == -1 or abs(left - right) > 1:
                return -1
            return 1 + max(left, right)

        return isBalancedHelper(root) != -1
