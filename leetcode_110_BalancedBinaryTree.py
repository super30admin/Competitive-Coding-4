# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:


        def helper(node):
            if node is None: return 0, True

            flag = False

            left_height, left_ans = helper(node.left) 
            right_height, right_ans = helper(node.right) 

            height = 1 + max(left_height, right_height) 

            difference = abs(left_height - right_height) 


            if difference <= 1 and left_ans and right_ans:
                flag = True
            else: flag = False

            return [height, flag]

        height, answer = helper(root)
        return answer



        