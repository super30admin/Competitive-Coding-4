// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
Bottom -up approach.
we check if the child subtrees are balanced or not then we also use height to check if the parent node is balanced or not.In this way we check the whole tree and if the height of the left and right sub trees at every node is less than or equal to 1 and if the left and right sub trees are balanced then we say that the tree is balanced binary tree.

Time complexity --> o(n)
space complexity --> o(h)
class Solution:
    def dfs(self,root):
    #leaf node
        if root==None:
            return True,0
        leftbalance,leftheight=self.dfs(root.left)
        #if true is not returned we return False indicating that the tree is not balanced
        if not leftbalance:
            return False,0
        rightbalance,rightheight=self.dfs(root.right)
        if not rightbalance:
            return False,0
        #to check if the tree is balanced or not we check the height of left and right sub trees and the height difference should be <=1 and the child sub trees should be balanced.
        return (abs(leftheight-rightheight)<=1,1+max(leftheight,rightheight))
            
    def isBalanced(self, root: TreeNode) -> bool:
        return self.dfs(root)[0]
        
Top-Down Approach:
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
Top-Down Approach
For every node in the given tree we calculate the height of the tree and if the height <=1 and left and right sub trees are balanced then we say that the tree is balanced.

Time complexity --> o(n*logn)
space complexity--> o(h)

class Solution:
    def height(self,root):
        if root==None:
            return 0
        return 1+max(self.height(root.left),self.height(root.right))
    
    def isBalanced(self, root: TreeNode) -> bool:
        if root==None:
            return True
        
        if abs(self.height(root.left)-self.height(root.right))<=1 and self.isBalanced(root.left) and self.isBalanced(root.right):
            return True
        return False
            
        
        
        
        