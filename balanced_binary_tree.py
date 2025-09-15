# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''
DFS: Recursion (with conditional/Early Stopping)
when we hit the Null Pointe (i.e. leaf node), return 0 as height of left-subtree=0
    - case1 = 1 + height of left subtree 
    - case2 = 1 + height of right subtree
    - check |case1 -case2|<=1 -> True - Balanced, False - Not Balanced
    - return max(case1,case2)
Time Complexity: O(N) - Traversing each node
Space Complexity: O(h), h = height, worst case O(N), best case O(log N)
'''
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root==None: # edge case
            return True
        
        self.isBalanced = True
        self.helper(root) # curr node

        return self.isBalanced
    
    def helper(self,node):
        # base
        if node==None:
            return 0

        # logic
        # left
        case1 = 0
        if self.isBalanced:
            case1 = 1 + self.helper(node.left)
        # right
        case2 = 0
        if self.isBalanced:
            case2 = 1+ self.helper(node.right)

        if abs(case1-case2)>1:
            self.isBalanced = False

        return max(case1,case2)
