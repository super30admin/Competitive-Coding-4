# Time Complexity : O(n)
# Space Complexity : 0(n)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach


class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
            lefth = heigh(root.left)
            righth= height(root.right)
            if abs(lh-rh) <=1 and isBalanced(root.left) is true and isbalanced(root.right) is True:
                return True
            return False
    def height( self,node):
        if node == None :
            return 0
        return max(height(node.left),height(node.right)) +1