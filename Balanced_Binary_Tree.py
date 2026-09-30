# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# First approach is creating a height function which provides only the height for each node in the binary tree
# In the isbalanced we check if the tree is balanced by calling the height function for every node to calculate the left and right height and then checking if the difference is greater than 1
# But this approach takes Nlogn time complexity so in order to avoid calling the height function every time
# Second approach from bottom up we calculate the height for each node and also check the difference is greater than 1
# If it is greater then return -1 and if the left = -1 or right = -1 then return -1 we dont need to calculate the top we will just return -1 as height


class Solution:
    def isBalanced(self, root: TreeNode | None) -> bool:
        if not root:
            return True
        return self.isBalanced(root.left) and self.isBalanced(root.right) and abs(self.height(root.left) - self.height(root.right)) <= 1


    def height(self, root):
        if not root:
            return 0
        left = self.height(root.left)
        right = self.height(root.right)

        return 1 + max(left, right)
#Time - O(Nlogn)
#Space - O(H)

class Solution:
    def isBalanced(self, root: TreeNode | None) -> bool:
        if not root:
            return True
        return self.height(root) != -1

    def height(self, root):
        if not root:
            return 0
        left = self.height(root.left)
        if left == -1:
            return -1
        right = self.height(root.right)
        if right == -1:
            return -1
        if abs(left - right) > 1:
            return -1
        return 1 + max(left, right)