class Solution:
    def height(self,root):
        if not root:
            return -1
        return 1+max(self.height(root.left),self.height(root.right))
    def isBalanced(self, root: TreeNode) -> bool:
        if not root:
            return True
        return abs(self.height(root.left) - self.height(root.right)) <= 1 and self.isBalanced(root.left) and self.isBalanced(root.right)

#Time-Complexity: O(N)
#Space-Complexity: O(N)