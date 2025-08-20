# Height Balanced Binary Tree
# We are using bottom-up recursion and checking if the left and right subtrees are balanced and ensuring their heights differ by at most one.
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def helper(root):
            if not root:
                return True,0
            left, right = helper(root.left), helper(root.right)
            balanced = left[0] and right[0] and abs(left[1]-right[1])<2
            return balanced, 1+max(left[1],right[1])
        return helper(root)[0]