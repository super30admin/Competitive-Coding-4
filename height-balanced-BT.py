"""
Runtime Complexity:
O(n)- we define a function which determines the height of the tree. We iterate recursively and if the left subtree's height
and right subtree's height is less than 2 then we might have a balanced tree. So we iterate through both left and right to compare. We return true if they are balanced
else false.
Space Complexity:
O(1) - no extra space was used to compute the solution. Therefore its constant.
Yes, the code worked on leetcode.
Issues while code- no
"""
class Solution:
    def height(self,root):
            if not root:    #empty tree has height -1
                return -1
            return 1+max(self.height(root.left),self.height(root.right))
        
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root:    #empty tree is always balanced
            return True
        return abs(self.height(root.left)-self.height(root.right))<2 and self.isBalanced(root.left) and self.isBalanced(root.right)
        
        
        