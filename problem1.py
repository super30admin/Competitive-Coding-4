#Time Complexty O(N)
#Space Complexity O(N)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
#     def check_left_root(self,root,current_height):
#         if root !=None:
#             self.check_left_root(root.left,current_height)
#             current_height+=1
#         return abs(current_height)
    
#     def check_right_root(self,root,current_height):
#         if root !=None:
#             self.check_left_root(root.right,current_height)
#             current_height+=1
#         return abs(current_height)
            
    # def check_height_func(self,root,current_height):
    #     if not root:
    #         return -1
    #     if root!=None:
    #         self.check_height_func(root.left,current_height)
    #         current_height +=1
    #         self.check_height_func(root.right,current_height)
    #         current_height-=1
    #     return abs(current_height)
    def check_height_func(self,root):
        
        if root ==None:
            return True,-1
        isleft, left_h=self.check_height_func(root.left)
        if not isleft:
            return False,0
        isright,right_h = self.check_height_func(root.right)
        if not isright:
            return False,0
        
        return (abs(left_h - right_h) <2), 1 +max(left_h,right_h)
        
            
            
            
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        
        # result  = self.check_height_func(root,current_height_left,current_height_right)
        result  = self.check_height_func(root)
        return result[0]
        # left_tree_height = self.check_left_root(root)
        # right_tree_height = self.check_right_root(root)
        # if result :
        #     return False
        # else:
        #     return True
        
        
        
        
        
        
