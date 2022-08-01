# Time Complexity : O(n)
# Space Complexity : O(1)


class Solution:
    def helper(self, root):
        if root == None:
            return 0
        lh = self.helper(root.left)
        rh = self.helper(root.right)
        return max(lh, rh) + 1
    
    def isBalanced(self, root):
        if root == None:
            return True
        if(self.isBalanced(root.left) == False or self.isBalanced(root.right) == False):
            return False
        ans1 = self.helper(root.left)
        ans2 = self.helper(root.right)
        
        diff = ans1 - ans2
        if abs(diff) > 1:
            return False
        
        return True
            