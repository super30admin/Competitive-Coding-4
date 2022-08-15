# Time complexity : O(n)
# Space complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    
    def check(self, root):
            
            if not root:
                return [True, 0]
            
            
            left = self.check(root.left)
            right = self.check(root.right)
            
            check_balanced = left[0] and right[0] and (abs(left[1] - right[1]) <= 1)
            
            
            return [check_balanced, 1 + max(left[1], right[1])]
        
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        return self.check(root)[0]
