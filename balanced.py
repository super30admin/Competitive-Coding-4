#TC-O(n)
#SC-O(n)
#logic - tranverse through the tree in post order and get the depths, check if left and right depths differ by more than 1, then set global result to false
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        global result
        result = True
        def helper(root):
            global result
            if not root:
                return 0
            if not root.left and not root.right:
                return 1
            left = helper(root.left)
            right = helper(root.right)
            print(left,right)
            if abs(left-right)>1:
                result = False
                print(result)
            return max(left,right)+1
        
        helper(root)
        print(result)
        return result
        


