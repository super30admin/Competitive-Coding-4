# Time Complexity: O(N)
# Space Complexity: O(H)
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
      def helper(node, height):
        if node is None:
          return True, height
        
        bal_l, h_l = helper(node.left, height + 1)
        bal_r, h_r = helper(node.right, height + 1)
        bal = (h_l - h_r) <= 1 if h_l > h_r else (h_r - h_l) <= 1

        return bal_l and bal_r and bal, max(h_l, h_r)
      
      return helper(root, 0)[0]
