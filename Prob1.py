# Time complexity : O(n), number of nodes
# Space complexity : O(H), height of the tree

# Calculate height at each node, if diff between left adn right>1 immediately set flag false. 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        self.flag=True
        def helper(root):
            #base
            if not root: return 0

            #logic
            left=helper(root.left) #get left child's height
            right=helper(root.right) #get right child's height

            if abs(right-left)>1: #if height diff more than 1, set flag false
                self.flag=False
            return 1+max(left,right) #for current node's val we do +1 of it's max of left and right children's value
        helper(root)
        return self.flag



            