
# S30 Mock Problem #2 Balanced Binary Tree
#LeetCode #110 https://leetcode.com/problems/balanced-binary-tree/description/

# Author : Akaash Trivedi
# Time Complexity : O(h) height of tree
# Space Complexity : O(1) h -> height of resursive stack space
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No


# treating it as right and left subproblems, recursively calculate the heights
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root) != -1

    def helper(self,root)->int:
        if root == None: return 0
    
        left = self.helper(root.left)
        right = self.helper(root.right)
        # print(root,left, right)

        # check for a stew tree/ break if we find inbalance by -1
        if left == -1 or right == -1 or abs(left - right) > 1:
            return -1
        
        # height is max between left and right subtree
        return max(left,right)+1