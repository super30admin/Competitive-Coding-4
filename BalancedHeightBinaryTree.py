# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:

    #Here we traverse all the nodes. For each node we get its left height and right height. If the difference b/w the heights is more than 1 then we make the flag false. for each node we return the max of its left or right height and plus 1(self)
    #Time complexity - O(n)
    #Space complexity - O(1)
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        
        def helper(root):
            if not root:
                return 0
            
            left = helper(root.left)
            right = helper(root.right)

            if abs(left-right)>1:
                self.flag = False

            return 1+max(left,right)
        
        helper(root)
        return self.flag


