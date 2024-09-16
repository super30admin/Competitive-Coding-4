# O(N) TIME AND O(D) SPACE WHERE N IS NO.OF NODES AND D IS DEPTH OF BT

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        return self.isBalancedHelper(root)[0]

    def isBalancedHelper(self,node):
        if node is None:
            return [True,-1]
        
        left_balanced, left_height = self.isBalancedHelper(node.left)
        if not left_balanced:
            return [False,0]
        right_balanced, right_height = self.isBalancedHelper(node.right)
        if not right_balanced:
            return [False,0]

        return [abs(left_height - right_height) < 2 , 1 + max(left_height,right_height)]

