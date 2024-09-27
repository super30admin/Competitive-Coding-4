class Solution(object):
    def isBalanced(self, root):       
    
        height,isBalanced = self.solver(root)
        return isBalanced


    def solver(self,root):
        if root is None:
            return 0,True
        left_height,left_isBalanced = self.solver(root.left)
        right_height,right_isBalanced = self.solver(root.right)
        height = max(left_height,right_height)+1
        if left_isBalanced is False or right_isBalanced is False or (left_height - right_height)**2 > 1:
            return height,False
        else:
            return height,True

%TC: O(n)
%SC: O(h)
