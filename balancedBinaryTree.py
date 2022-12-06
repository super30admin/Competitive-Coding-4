# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''
Time Complexity -->
O(n)

Space Complexity -->
O(h)
'''
class Solution:
    def __init__(self):
        self.check = True
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.heightCheck(root)
        return self.check
    def heightCheck(self, root):
        if root!=None:
            if root.left==None and root.right==None:
                return 1
            left = self.heightCheck(root.left)
            right = self.heightCheck(root.right)
            #print(left,end =' ')
            #print(right)
            if abs(left-right)>=2:
                self.check = False
                print(self.check)
            return max(left, right)+1
        else:
            return 0
        