def isBalanced(self, root: Optional[TreeNode]) -> bool:
    self.flag=True
    self.helper(root)
    return self.flag

def helper(self, root):
    if root is None:
        return 0
    left=self.helper(root.left)+1
    right=self.helper(root.right)+1

    if abs(left-right)>1:
        self.flag=False
    return max(left,right)