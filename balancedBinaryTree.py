# Time Complexity: O(n), where n is the number of nodes in the binary tree
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# 1. Use a recursive function to check the height of the left and right subtrees.
# 2. If the absolute difference in height is greater than 1 at any node, set a flag to False.
# 3. Return the height of the current node.
# 4. If the flag is still True after checking all nodes, return True, indicating the tree is balanced.
# Definition for a binary tree node.
class Solution:
    def isBalanced(self, root) -> bool:
        # Initialize a flag to True
        # This will be used to determine if the tree is balanced
        self.flag = True
        # Recursive function to check the height of the left and right subtrees
        def check(node):
            # Base case: if the node is None, return height 0
            if not node:
                return 0
            
            # Recursively check the height of the left and right subtrees
            left = check(node.left)
            right = check(node.right)

            # If the absolute difference in height is greater than 1, set the flag to False
            if abs(left - right) > 1:
                self.flag = False

            # Return the height of the current node
            return 1 + max(left, right)

        # Start the recursive check from the root node
        check(root)
        # Return the flag indicating if the tree is balanced
        return self.flag