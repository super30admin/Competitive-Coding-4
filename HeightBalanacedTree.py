# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

//Time Complexity: O(n)
//Space Complexity: O(n)

// Did it run successfully on leetcode: Yes
class Solution(object):
    def isBalanced(self, root):
        res = self.helper(root)
        if(res !=-1):
            return True
        else:
            return False
    
    
    def helper(self,root):
        if not root:
            return 0
        left = self.helper(root.left)
        if(left == -1):
            return -1
        right = self.helper(root.right)
        if(right == -1):
            return -1
        if(abs(left-right)>1):
            return -1
        return 1+max(left,right)
        
        
        
        
        
