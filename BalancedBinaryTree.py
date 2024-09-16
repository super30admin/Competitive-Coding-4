# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # def __init__(self):
    #     self.Flag=0
    
    """Time complexity-O(n)
    Space Complexity-O(h) as we are using stack internally"""
    def isBalanced(self, root: TreeNode) -> bool:
        if not root:
            return True
        return self.isBalanced(root.left) and self.isBalanced(root.right) and abs(self.height(root.left)-self.height(root.right))<=1
    
    def height(self, root):
        if not root:
            return 0
        else:
            return max(self.height(root.left), self.height(root.right))+1
        
#         height=0
#         self.helper(root, height)
#         if self.Flag==1:
#             return False
#         else:
#             return True
    
#     def helper(self,root, height)->int:
#         if not root:
#             return height-1
#         case1=self.helper(root.left, height+1)
#         case2=self.helper(root.right, height+1)
        
#         if abs(case1-case2)>1:
#             self.Flag=1
#             return self.Flag
#         else:
#             height=max(case1, case2)
#             return height
        
            
        
        