# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# We check the max heights of left subtree and right subtree recursively and if they are more than 2
# we return false else true if the child subtrees return true

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        def check_balance(root, depth):
            #Terminating condition
            if not root:
                return depth, True

            #Operation
            left_depth, is_l_valid = check_balance(root.left, depth+1)
            right_depth, is_r_valid = check_balance(root.right, depth+1)
            return max(left_depth, right_depth), abs(left_depth - right_depth) <= 1 and is_l_valid and is_r_valid
        
        if not root: return True
        
        return check_balance(root, 0)[1]