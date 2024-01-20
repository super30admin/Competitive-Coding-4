
"""
110. Balanced Binary Tree
Easy
"""
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
Given a binary tree, determine if it is height-balanced.
 
Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:

Input: root = []
Output: true

 
Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104


"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    """
    Accepted
    Time Complexity: O(n)
    Space Complexity: O(h)
    Explanation: Instead of calculating heights of each subtree while traversing the tree,
        we came up with a bottom up approach. DFS to the bottom of the tree and calculate the height
        and check the balance, then return both the height and balance to the parent node.
        The parent node then checks the balance and returns the balance and height to its parent node.
        This continues until the root node is reached. If the root node is balanced, then the tree is balanced.
        
        This is an improvement over the previous solution because we don't have to calculate the height of each subtree
        which is effecient because we don't have to traverse the tree multiple times.
    """
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def rec(root) -> (bool, int):
            if root is None:
                return (True, 0)
            
            left, right = rec(root.left), rec(root.right)
            balanced = (left[0] and right[0] and
                        abs(left[1] - right[1]) <=1 )
            
            return (balanced, 1 + max(left[1], right[1]))
        return rec(root)[0]
    
    """
    Accepted
    Time Complexity: O(n^2)
    Space Complexity: O(h)
    Solution Explanation:
        For each node, we calculate the height of the left and right subtree.
        If the difference between the height of the left and right subtree is
        greater than 1, then the tree is not balanced. We do this recursively
        for each node in the tree.
    """
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def height(root):
            if root is None:
                return 0
            return max(height(root.left), height(root.right)) + 1
        def rec(root):
            if root is None:
                return True
            l = height(root.left)
            r = height(root.right)
            if abs(l  - r) <= 1 and (rec(root.left) and rec(root.right)):
                return True
            return False
        return rec(root)

LeetCode(PROBLEM, Solution).check()
