# Time Complexity : O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :

class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def dfs(root):
            if not root:
                return [True, 0]
            left = dfs(root.left)
            right = dfs(root.right)
            balanced = left[0] and right[0] and (abs(left[1]-right[1])<=1)
            return [balanced, 1+max(left[1],right[1])]
        return dfs(root)[0]