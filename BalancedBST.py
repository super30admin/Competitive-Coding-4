"""Time Complexity : O(n)
// Space Complexity : O(n) n - > recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approachrigt
At each node calculate the height of the left and right subtree by recursion"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def isBalanced(self, root: TreeNode) -> bool:
        if not root:
            return True   
        leftht = self.height(root.left)
        rightht = self.height(root.right)
        
        if abs(leftht-rightht)>1:
            return False
        return self.isBalanced(root.left) and self.isBalanced(root.right)
    
    def height(self, root: TreeNode):
        # root exist
        
        if not root:
            return 0
        
        return max(self.height(root.left),self.height(root.right))+1 
