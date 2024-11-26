#Time Complexity:O(n)
#Space Complexity:O(h)
class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None:
            return True
        if(abs(self.dfs(root.left)-self.dfs(root.right))>1):
            return False
        return self.isBalanced(root.left) and self.isBalanced(root.right)
    
    def dfs(self,root):
        if root==None:
            return -1
        case1=self.dfs(root.left)
        case2=self.dfs(root.right)
        return max(case1,case2)+1