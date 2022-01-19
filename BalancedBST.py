# // H -> height of tree, N -> number of nodes
# // Time Complexity : O(NlogN)
# // Space Complexity : O(H)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        
        return self.isBalanced(root.left) and  self.isBalanced(root.right) and abs(self.height(root.left) -self.height(root.right)) <= 1
    
            
    def height(self, root):
        if root == None:
            return 0
        
        return max(self.height(root.left),self.height(root.right))+1

    
# // H -> height of tree, N -> number of nodes
# // Time Complexity : O(N)
# // Space Complexity : O(H)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
    # Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        
        return self.height(root) != -1
    
            
    def height(self, root):
        if root == None:
            return 0
        
        left = self.height(root.left)
        right = self.height(root.right)
        if abs(left -right) > 1:
            return -1
        if left == -1 or right == -1:
            return -1
        return max(left, right) + 1
        
        
        