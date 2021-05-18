# TC: O(N) since we are traversing all the nodes
# SC: O(H) where H is the depth of the tree or the size of the recursive stack.

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        self.height = 0
        def helper(root):
            if not root:
                return 0
            
            left_balanced = helper(root.left)
            if left_balanced == -1:
                return -1
            right_balanced = helper(root.right)
            if right_balanced == -1:
                return -1
            
            self.height = max(left_balanced, right_balanced) + 1
            
            if abs(left_balanced - right_balanced) > 1:
                return -1
            
            return self.height
        
        if helper(root) == -1:
            return False
        return True
