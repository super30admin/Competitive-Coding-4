# #Approach-1: Top-down pre-order
# #Brute force: At every node, recursively:
# 	# 1.	Compute the height of the left subtree.
# 	# 2.	Compute the height of the right subtree.
# 	# 3.	Check if their height difference is ≤ 1.
# 	# 4.	Recursively check if left and right subtrees are balanced.
# #TC:O(n^2): Because for each of the n nodes, we're doing a height computation that traverses all its subtrees again.
# #SC:O(h) — due to recursion stack, where h is the height of the tree.
# class Solution:
#     def isBalanced(self, root: Optional[TreeNode]) -> bool:
#         if root is None:
#             return True
        
#         left_height = self.getHeight(root.left)
#         right_height = self.getHeight(root.right)

#         # If current node is unbalanced, return False
#         if abs(left_height - right_height) > 1:
#             return False
        
#         # Otherwise, check if left and right subtrees are balanced
#         return self.isBalanced(root.left) and self.isBalanced(root.right)

#     def getHeight(self, node: Optional[TreeNode]) -> int:
#         if node is None:
#             return 0
#         return 1 + max(self.getHeight(node.left), self.getHeight(node.right))

#Approach-2: Bottom-up, postorder
#The helper function recursively calculates height while checking balance at every node.
#If the height difference exceeds 1, flip the flag and skip further processing.
# Tc = O(n), each node visited once
# SC = O(h), recursive stack
class Solution:
    def isBalanced(self, root):
        self.flag = True
        self.helper(root)
        return self.flag
    def helper(self, root):
        if root is None:
            return 0
        left = 0
        right = 0
        if self.flag:
            left = self.helper(root.left) + 1
        if self.flag:
            right = self.helper(root.right) + 1
        if abs(left - right) > 1:
            self.flag = False
        return max(left, right)
