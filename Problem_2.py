"""
Time Complexity : O(n)
Space Complexity : O(h) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
This is a bottom up approach for recursion. Here we first go to the left most node and then start coming up.
As we come up, we return the maximum length between the left and the right subtree. As soon as the
absolute difference becomes greater than 1, we return False.
"""


class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if not root:
            return True
        self.flag = True
        self.helper(root)
        return self.flag

    def helper(self, root):
        if not root:
            return 0
        l = self.helper(root.left)
        r = self.helper(root.right)
        if abs(r-l) > 1:
            self.flag = False
        return max(l, r)+1
