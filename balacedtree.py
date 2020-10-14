class Solution:
    def height(self,root):
        if not root:
            return -1
        return 1 + max(self.height(root.left),self.height(root.right))
    def isBalanced(self, root: TreeNode) -> bool:
        if not root:
            return True
        
        return abs(self.height(root.left)-self.height(root.right))<2 and self.isBalanced(root.left) and self.isBalanced(root.right)
        #tc is nlogn and sc is o(n)
