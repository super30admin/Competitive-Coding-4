# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        #as we are checking height of tree with difference. use->DFS
        #Recursive solution
        """
        Time Complexity: O(N)
        Space Complesity: O(N)
        Accepted.
        """
        self.balance = True
        self.dfs(root)
        return self.balance
    
    def dfs(self,root):
        
        if not root or self.balance==False:
            return 0
        
        leftHeight = self.dfs(root.left)
        rightHeight = self.dfs(root.right) 
        
        if abs(leftHeight-rightHeight)>1:
            self.balance=False
        
        return max(leftHeight, rightHeight)+1