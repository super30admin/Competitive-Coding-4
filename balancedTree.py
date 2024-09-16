# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        #base case
        if root == None: 
            return True
        
        def height(root):
            if root == None:
                return 0
            
            left = height(root.left)
            right = height(root.right)
            
            return max(left,right)+1
        
        #going to the left most root
        left = self.isBalanced(root.left)
        #left call stack.pop() happens if root = None 
        
        #going to right node of the popped root
        right = self.isBalanced(root.right)
        #right call stack.pop() happens
        
        #calculate the max height at the nodes
        maxHeight = abs(height(root.left) - height(root.right)) 
        
        return left and right and maxHeight<=1
    
#Time complexity is O(n) and space complexity O(h)
#going to the left and right node of the tree and returning 0 for null node, null +1 for the one above and so on.
                
        