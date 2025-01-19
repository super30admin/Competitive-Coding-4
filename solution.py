# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        ### Initialize Approach
        # TC- O(n*logh) -> n
        # SC - O(1)
        #   if not root:
        #     return True
        # if abs(self.calculateHeight(root.left) - self.calculateHeight(root.right))>1:
        #     return False
        # return self.isBalanced(root.left) and self.isBalanced(root.right)  


       #### optimize aproach leaf to root approach 
        # TC - O(n)
        #Sc - O(1)
        if not root:
            return True

        if self.calculateHeight(root)!=-1:
            return True
        return False    



    def calculateHeight(self, root)->int:
        # Approach 1 code
        # if not root:
        #     return 0
        # return 1+ max(self.calculateHeight(root.right),self.calculateHeight(root.left))  

        
        #optimize Approach code
        if not root:
            return 0
        left = self.calculateHeight(root.left)
        right = self.calculateHeight(root.right)

        print(left)

        if abs(left-right)>1:
            return -1

        if left == -1 or right == -1:
            return -1    
        
        return 1 + max(right,left)    

        
