"""
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node 
differ in height by no more than 1.

// Time Complexity : ON
// Space Complexity :OH, h is height of tree
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


"""

class Solution:
    def isBalanced(self, root):
        self.Bal = True
        
        def dfs(node):
            if not node: return 0
            lft, rgh = dfs(node.left), dfs(node.right)
            if abs(lft - rgh) > 1: self.Bal = False
            return max(lft, rgh) + 1
            
        dfs(root)
        return self.Bal