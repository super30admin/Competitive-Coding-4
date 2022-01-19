# TC: O(N) // EACH NODE 
# SC: O(1) // because we're pasing the an array with two elements in each recursion.if that's not the case then O(N)
# LC: YES
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
        def isBalanced(self, root: Optional[TreeNode]) -> bool:
            
            def dfs(root):
                if not root: return [True, 0]
                isLeftBalanced = dfs(root.left)
                isRightBalanced = dfs(root.right)
                isBal = isLeftBalanced[0] and isRightBalanced[0] and (abs(isRightBalanced[1] - isLeftBalanced[1]) <= 1)
                return [isBal, max(isLeftBalanced[1], isRightBalanced[1]) +1]
            return dfs(root)[0]