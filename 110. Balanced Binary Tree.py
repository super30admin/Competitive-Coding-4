#recursive DFS - O(nlogn)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None: return True
       
        def height(root):
            if (root == None): return 0
            else:
                return max(height(root.left),height(root.right))+1
        
        return self.isBalanced(root.left) and self.isBalanced(root.right) and abs(height(root.left)-height(root.right)) <= 1


# Bottom Up Recursion TC - O(n) 
#We check the height balance at children first If the height at children is not balanced. We are returning -1 to parent Check the balance of tree at time of checking height itself

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        if root == None: return True
       
        def height(root):
            if (root == None): return 0
            left, right = height(root.left), height(root.right)
            if (abs(left-right) > 1 or left == -1 or right == -1):
                return -1
            return max(left,right)+1

        return height(root) != -1