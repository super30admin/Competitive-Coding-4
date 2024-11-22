# The code defines an isBalanced method to check whether a binary tree is height-balanced.
# A binary tree is height-balanced if the depth of the two subtrees of every node never differs by more than 1.

# Helper Function (dfs):
#   - The dfs function performs a postorder traversal of the tree to determine whether it is balanced and calculates the height of each subtree.
#   - Base Case:
#       - If the current node is None (i.e., a leaf node is reached), return [True, 0]:
#           - True indicates that an empty subtree is balanced.
#           - 0 is the height of an empty subtree.
#   
# Recursive Case:
#   - Call dfs on the left and right subtrees to get their balance status and heights.
#   - Check if the current node is balanced:
#       - A node is balanced if:
#           - Both its left and right subtrees are balanced (left[0] and right[0] are True).
#           - The absolute difference between the heights of the left and right subtrees is at most 1 (abs(left[1] - right[1]) <= 1).
#   - Return a list:
#       - The first element is the balanced status (True or False) for the current subtree.
#       - The second element is the height of the current subtree (1 + max(left[1], right[1])).

# Main Execution:
#   - The isBalanced method starts the recursive dfs function on the root node.
#   - It returns the balanced status (first element) of the root, indicating whether the entire tree is balanced.

# TC: O(n) - Each node is visited once during the traversal, making the time complexity linear in the number of nodes.
# SC: O(h) - The space complexity is proportional to the height of the tree due to the recursion stack.


from typing import Optional


class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool: # type: ignore
        def dfs(root):
            if not root:
                return [True, 0]

            left, right = dfs(root.left), dfs(root.right)
            balanced = left[0] and right[0] and abs(left[1] - right[1]) <= 1
            return [balanced, 1 + max(left[1], right[1])]

        return dfs(root)[0]