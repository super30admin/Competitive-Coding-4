class Solution:
    def CheckBalanced(self, root) -> bool:
        
        if not root:
            return True

  
        return abs(self.getHeight(root.left) - self.getHeight(root.right)) < 2 and self.CheckBalanced(
            root.left) and self.CheckBalanced(root.right)


    def CalHeight(self, root):
        if not root:
            return 0
        x = max(self.CalHeight(root.left), self.CalHeight(root.right))
        return 1 + x