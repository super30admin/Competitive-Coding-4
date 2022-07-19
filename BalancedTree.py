# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity => O(N)
# Space Complexity => O(H) or O(1)
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.height = 0
        balanced = 0
        temp = root
        def traverse(root):
            if(root is None):
                return 0
            left = traverse(root.left)
            right = traverse(root.right)
            if(left==-1 or right==-1 or abs(left-right)>1):
                return -1
            self.height = max(left,right)
            return 1+self.height
        balanced = traverse(root)
        if(balanced!=-1):
            return True
        else:
            return False
            
            
            
        