# // Time Complexity :O(n)
# // Space Complexity :O(height)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        global flag
        flag = False
        def dfs(root):
            global flag
            if not root:
                return 0
            if flag:
                return 0
            left = 1 + dfs(root.left)
            right = 1 + dfs(root.right)
            if abs(left - right) > 1:
                flag = True
            return max(left, right)
        dfs(root)
        if flag == True:
            return False
        return True