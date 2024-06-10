# Time Complexity : O(n), n is the number of nodes
# Space Complexity : O(h), h is the height of the binary tree
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def checkHeight(self, root):
        if root is None:
            return 0
        
        left_height = self.checkHeight(root.left)
        if left_height == -1:
            return -1
        
        right_height = self.checkHeight(root.right)
        if right_height == -1:
            return -1
        
        if abs(left_height - right_height) > 1:
            return -1
        
        return max(left_height, right_height) + 1
    
    def isBalanced(self, root):
        return self.checkHeight(root) != -1

# Helper function to create binary tree from a list of values (level order)
def create_binary_tree(values):
    if not values:
        return None
    root = TreeNode(values[0])
    queue = [root]
    index = 1
    while index < len(values):
        node = queue.pop(0)
        if values[index] is not None:
            node.left = TreeNode(values[index])
            queue.append(node.left)
        index += 1
        if index < len(values) and values[index] is not None:
            node.right = TreeNode(values[index])
            queue.append(node.right)
        index += 1
    return root

# Example 1
values1 = [3, 9, 20, None, None, 15, 7]
root1 = create_binary_tree(values1)
sol = Solution()
print(sol.isBalanced(root1))  # Output: True

# Example 2
values2 = [1, 2, 2, 3, 3, None, None, 4, 4]
root2 = create_binary_tree(values2)
print(sol.isBalanced(root2))  # Output: False

# Example 3
values3 = [1, 2, 2, 3, None, None, 3, 4, None, None, 4]
root3 = create_binary_tree(values3)
print(sol.isBalanced(root3))  # Output: False