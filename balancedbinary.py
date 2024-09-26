# Time Complexity :O(n) 
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this : No
class Solution:
#     TC--->O(n)
# SC---O(1)
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return self.traverse(root) != float("inf")
    
    def traverse(self,root):
        if root==None:
            return 0
        left=self.traverse(root.left)+1
        right=self.traverse(root.right)+1
        
        if abs(left-right)>1:
            return float("inf")
        return max(left,right)
    