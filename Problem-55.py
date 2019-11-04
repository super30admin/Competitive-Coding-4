# Leet code-Balanced Binary Tree-110
# Time complexity -O(H)
# space complexity-O(1)
# Approach -We need to find the left subtree is balanced and right sub tree is balanced and the difference between both and left and right subtrees should be less than or eual to 1.





# Definition for a binary tree node.
 class TreeNode(object):
        def __init__(self, x):
            self.val = x
            self.left = None
            self.right = None

class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root==None: return True
        else:
            return self.isBalanced(root.left) and self.isBalanced(root.right) and abs(self.height(root.left)-self.height(root.right))<=1
        
    def height(self,root):
        if root == None: return 0
        else:
            return  max(self.height(root.left),self.height(root.right))+1