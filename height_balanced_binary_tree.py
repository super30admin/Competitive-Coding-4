# https://leetcode.com/problems/balanced-binary-tree/description/
# Time Complexity- O(n) Space Complexity- O(1)

class Solution:
    def isBalanced(self, root):
        # to track the tree is balanced or not
        self.flag = True
        # call the helper function
        self.helper(root)
        # return the flag
        return self.flag

    def helper(self, root):
        # handle the edge case
        if root is None:
            return 0
        # initialise left tree height
        left = 0
        # initialise right tree height
        right = 0

        # if the flag is True
        if self.flag:
            left = self.helper(root.left) + 1
        if self.flag:
            right = self.helper(root.right) + 1
        # find the difference between the left and right subtrees
        if abs(left - right) > 1:
            self.flag = False
        # return the height of the current subtree
        return max(left, right)
