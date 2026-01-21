''' Time Complexity : O(n) 
    Space Complexity : O(h) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

'''

class Solution:
    def __init__(self):
        self.flag = True

    def isBalanced(self, root: Optional[TreeNode]) -> bool:

        def helper(root,h):
            if root is None:
                return h
            left = helper(root.left, h+1)
            right = helper(root.right, h+1)

            if abs(left - right) > 1:
                self.flag = False
            
            return max(left, right)

        helper(root,0)
        return self.flag