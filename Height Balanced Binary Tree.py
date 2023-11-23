# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO


# // Your code here along with comments explaining your approach
class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        isBalanced = True
        def dfs(root):
            nonlocal isBalanced
            if root == None:
                return 0
            leftHeight, rightHeight = dfs(root.left), dfs(root.right)
            if abs(leftHeight-rightHeight) > 1:
                isBalanced = False
            return 1 + max(leftHeight, rightHeight)
        dfs(root)
        return isBalanced       