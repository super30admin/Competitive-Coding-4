# Approach: In order to determine if a binary tree is balanced or not check the following
# 1. left subtree of node is balanced
# 2. right subtree of node is balanced
# 3. abs difference between left and right subtree is <= 1
# Time O(N)
# Space O(H)


class Solution:
    def isBalanced(self, root: TreeNode) -> bool:

        # base case 
        if root == None:
            return True

        return self.isBalanced(root.left) and self.isBalanced(root.right) and abs(self.depth(root.left) - self.depth(root.right)) <= 1
        
    
    def depth(self, root):

        if root == None:
            return 0

        return 1 + max(self.depth(root.left), self.depth(root.right))