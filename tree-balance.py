# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    '''
    Time Complexity: O(n)
    Space Complexity: O(n) for recursive stack
    '''
    def isBalanced(self, root: TreeNode) -> bool:
        # bottom up recursion
        if(root==None) or (root.left==None and root.right==None):
            return True
        #res = True
        def balance(root,depth):
            if(root==None):
                return depth,True
            d_left,isB = balance(root.left,depth+1)
            if(not isB):
                return 0,False
            d_right,isB = balance(root.right,depth+1)
            if(not isB):
                return 0,False
            if(abs(d_left-d_right)>1):
                return 0, False
            return max(d_left,d_right),True
        
        
        return balance(root,0)[0]
