# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    Time Complexity: O(n)
    Space Complexity: O(h)

    Approach:
        - we take the DFS Approach
        - we go to the leaf node and build from there
        - if node is None return 0
        - we will add 1 if we go to the parent node
        - we check the balance if the left and right node difference is less than 1 
            - if greater than 1 we return -1 
            - if any of the left or right child is unbalanced -> we return -1 for the parent as well
        - in the end, even if one node is unbalanced, we get -1 as the output of the tree
        - if it's -1 then return False else return True
    """
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        sym = self.helper(root)
        if sym == -1:
            return False
        return True

    def helper(self, node):
        if node == None:
            return 0
        left = self.helper(node.left)
        right = self.helper(node.right)
        if left == -1 or right == -1:
            return -1 
        if abs(left - right) > 1:
            return -1        
        return max(left, right) + 1