#https://leetcode.com/problems/balanced-binary-tree/
# Time Complexity: O(n) in the worst case (a perfectly balanced tree still needs every node checked), but often better in practice since we stop recursing further once an imbalance is found anywhere 
# Space Complexity: O(h), the recursion stack only ever goes as deep as the height of the tree.
# Approach: Use one helper function to compute height while also checking balance as a side effect. 
#The moment any node's left and right subtree heights differ by more than 1, flip a flag to False and stop doing further height work, since the answer is alreadydecided.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        
        self.flag = True            # assume balanced until proven otherwise
        self.helper(root)           # walk the tree, checking balance at every node
        return self.flag            # final verdict after the full walk

    def helper(self, root):     # Base case: an empty subtree has height 0 and can't be unbalanced
        if root is None:
            return 0
        
        right = 0
        left = 0

        # Only bother computing the left height if no imbalance has been
        # found yet elsewhere, once flag is False, skip this work entirely
        if self.flag is True:
            left = self.helper(root.left) + 1               # +1 counts this node itself
        
        # Same idea for the right side, skip if we already know the
        # answer is "not balanced" from some earlier part of the tree
        if self.flag is True:
            right = self.helper(root.right) + 1
        
        # If the two subtree heights at this node differ by more than 1,
        # this node alone disqualifies the entire tree from being balanced
        if abs(left - right) > 1:
            self.flag = False
        
        # Height of this subtree = 1 (this node) + the taller of its two
        # children's subtree heights, this is returned regardless of flag
        return max(left, right)