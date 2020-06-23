   ---------------------Is Balanced--------------------------------------   
# Time Complexity : O(N) N is the nodes
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here we can iterate through the binary tree and find the depth of left and right subtrees and check weather the difference of height of each subtree is greater than 2.
# If the difference is greater than 1 we can have a global variable saying is-balanced and update that as false
# return global variable once we complete iterating the entire tree.



class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        self.isBalanced = True
        
        def dfs(root):
            if not root:
                return 0
            
            l = dfs(root.left)
            r = dfs(root.right)
            
            if abs(l-r)>1:
                self.isBalanced = False
            
            return max(l,r)+1
        
        dfs(root)
        return self.isBalanced