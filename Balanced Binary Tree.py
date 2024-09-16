# Time Complexity : O(n), where n is the number of nodes in the tree.
# Space Complexity : O(h), stack space where h is the max height of the tree.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
class Solution(object):
    # This approach visits each node and for each node calculates
    # the height of its left and right subtree and if for any node
    # the height differs by more than one, return False.
    def isBalanced(self, root):
        if not root:
            return True

        left = self.height(root.left)
        right = self.height(root.right)
        if abs(left - right) > 1:
            return False
        return self.isBalanced(root.left) and self.isBalanced(root.right)

    def height(self, root):
        if root == None:
            return 0

        return max(self.height(root.left), self.height(root.right)) + 1
