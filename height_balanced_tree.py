""" Explanation: The height function calculates the height of the subtree rooted at the given node.
    If at any node, the heights of its left and right subtrees differ by more than 1 or if any 
    subtree is not balanced, the function returns -1.
    The is_balanced function checks if the overall tree is balanced by calling the height function. 
    If the height is -1, it means the tree is not balanced; otherwise, it is balanced.
    
    Time Complexcity: O(n)
    Space Complexcity: O(h), where h is the height of the binary tree
    All TC's passed on LC: Yes
"""

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def height(node):
            if not node:
                return 0
            left_height = height(node.left)
            right_height = height(node.right)
        
            # Check if the subtree is balanced
            if left_height == -1 or right_height == -1 or abs(left_height - right_height) > 1:
                return -1
            
            # Return the height of the subtree
            return max(left_height, right_height) + 1

        return height(root) != -1
        