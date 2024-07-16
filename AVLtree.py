#time = O(n)
#space = O(h)

class TreeNode:
    def __init__(self, value=0, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

def is_balanced(root):
    def check_balance(node):
        if not node:
            return 0, True
        
        left_height, left_balanced = check_balance(node.left)
        right_height, right_balanced = check_balance(node.right)
        
        current_height = max(left_height, right_height) + 1
        is_current_balanced = abs(left_height - right_height) <= 1
        
        return current_height, left_balanced and right_balanced and is_current_balanced
    
    _, balanced = check_balance(root)
    return balanced

# Example usage
# Constructing a balanced binary tree:
#        1
#       / \
#      2   3
#     / \
#    4   5

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)

print(is_balanced(root))  # Output: True