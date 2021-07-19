#Time Complexity: O(N).
#Auxiliary Space: O(h)
#Did this code successfully run on Leetcode :Yes

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution(object):

    def __init__(self):
        # self.diameter = 0
        self.result = True

    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def inorder_balanced(root):
            if not root:
                return 0

            left_sum = inorder_balanced(root.left)
            right_sum = inorder_balanced(root.right)

            if abs(left_sum-right_sum)>1:
                self.result = False
                # return

            return max(left_sum,right_sum)+1

        inorder_balanced(root)
        return self.result