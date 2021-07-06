

# Time Complexity: O(n)
# Space Complexity: O(h)
class Solution(object):
    # Initializing global variable
    flag = True

    def balancedBinary(self, root):
        # Checking base condition and flag value to stop recursion
        if not root or self.flag == False:
            return 0

        # get left and right subtree height
        hleft = self.balancedBinary(root.left)
        hright = self.balancedBinary(root.right)

        # if the difference between two subtree height is greater than 1 set flag to False
        if abs(hleft - hright) > 1:
            self.flag = False
        # return the height of the current root
        return 1 + max(hleft, hright)

    def isBalanced(self, root):

        self.balancedBinary(root)
        return self.flag
