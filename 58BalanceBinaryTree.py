"""
// Time Complexity :O(n2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NA

//Explanation:
Check if the left subtree and right subtree is balanced.
Check if the absolute difference between leftHeight and rightHeigh
is < = 1
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    # recursive
    def getHeight(self,root):
        if root is None:
            return 0
        else:
            return max(self.getHeight(root.left),self.getHeight(root.right)) + 1

    def isBalanced(self, root: TreeNode) -> bool:
        if root is None:
            return True

        leftHeight = self.getHeight(root.left)
        rightHeight = self.getHeight(root.right)

        if (abs(leftHeight-rightHeight) <= 1) and self.isBalanced(root.left) is True and                           self.isBalanced(root.right) is True:
            return True
        return False

"""
# iterative solution

class Solution:
    def getHeight(self,root):
        leftHeight, rightHeight = 0,0
        if root is None:
            return 0
        else:

            while(root.left is not None):
                leftHeight += 1
                root = root.left



            while(root.right is not None):
                rightHeight += 1
                root = root.right

        print("*",root.val,leftHeight,rightHeight)
        return max(leftHeight,rightHeight)

    def isBalanced(self, root: TreeNode) -> bool:
        if root is None:
            return True

        leftHeight = self.getHeight(root.left)
        rightHeight = self.getHeight(root.right)


        if (abs(leftHeight-rightHeight) <= 1) and self.isBalanced(root.left) is True and                           self.isBalanced(root.right) is True:
            return True
        return False
"""
