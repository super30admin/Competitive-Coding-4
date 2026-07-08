class Solution:
    def isBalanced(self, root):

        def dfs(node):
            if node is None:
                return 0

            left_height = dfs(node.left)
            if left_height == -1:
                return -1

            right_height = dfs(node.right)
            if right_height == -1:
                return -1

            if abs(left_height - right_height) > 1:
                return -1

            return max(left_height, right_height) + 1

        return dfs(root) != -1

# TC - O(n)
# SC - O(h)