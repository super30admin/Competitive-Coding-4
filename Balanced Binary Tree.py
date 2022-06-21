# time complexity is o(n), where  n is the size of the input
# space complexity is o(h), h = log(n), where  n is the size of the input.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # flag = True
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        result = self.helper(root)
        print(result[0])
        return result[1]    
    def helper(self, root):
        if(root == None):
            return (0, True)
        l = self.helper(root.left)
        lh = 1+l[0]
        ls = l[1]
        if(ls == False):
            return (lh, False)
        r = self.helper(root.right)
        rh = 1 + r[0]
        rs = r[1]
        return (max(lh,rh), ls and rs and abs(lh - rh) < 2)
        
    #     self.helper(root)
    #     return self.flag
    # def helper(self, root):
    #     if(root == None):
    #         return 0
    #     left = 1 + self.helper(root.left)
    #     right = 1 + self.helper(root.right)
    #     self.flag = self.flag and (abs(left - right) < 2)
    #     return max(left, right)
        