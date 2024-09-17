'''
    Time Complexity:
        O(n) (where n = number of nodes)

    Space Complexity:
        O(h) (where h = height of the tree)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Easy recursive approach
'''
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        return self.balance_height(root)[0]

    def balance_height(self, root):
        if root is None:
            return True, 0

        left_balance, left_height = self.balance_height(root.left)

        if not left_balance:
            return False, left_height

        right_balance, right_height = self.balance_height(root.right)

        if not right_balance:
            return False, right_height

        return abs(left_height - right_height) < 2, 1 + max(left_height, right_height)
