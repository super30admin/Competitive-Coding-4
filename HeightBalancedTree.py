"""
Rasika Sasturkar
Time Complexity: top-down: O(nlogn), bottom-up: O(n)
Space Complexity: O(n)
"""


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        """
        tree node constructor
        """
        self.val = val
        self.left = left
        self.right = right


def createTree(array_order, index, n):
    """
    Used for constructing a binary tree.
    """
    if array_order is None:
        return None
    root = None
    if index < n and array_order[index] is not None:
        root = TreeNode(val=array_order[index])
        root.left = createTree(array_order, 2 * index + 1, n)
        root.right = createTree(array_order, 2 * index + 2, n)
    return root


def isBalanced(root) -> bool:
    """
    In top-down approach, we check at last if the left subtree and right subtree
    of the root are balanced or not.
    In bottom-up approach, we first check if the left subtree and right subtree of
    the root are balanced or not.
    """

    # Top-Down approach
    # def height(root):
    #     if root is None:
    #         return -1
    #     return 1 + max(height(root.left), height(root.right))
    #
    # # empty tree
    # if root is None:
    #     return True
    #
    # return abs(height(root.left)-height(root.right))<2 and isBalanced(root.left) and isBalanced(root.right)

    # Bottom-Up approach
    def helper(root):
        if root is None:
            return True, -1
        left_balanced, left_height = helper(root.left)
        if not left_balanced:
            return False, 0
        right_balanced, right_height = helper(root.right)
        if not right_balanced:
            return False, 0
        return abs(left_height - right_height) < 2, 1 + max(left_height, right_height)

    return helper(root)[0]


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    array_order = [3, 9, 20, None, None, 15, 7]
    root = createTree(array_order, 0, len(array_order))
    print(isBalanced(root))  # returns True

    array_order = [1, 2, 2, 3, 3, None, None, 4, 4]
    root = createTree(array_order, 0, len(array_order))
    print(isBalanced(root))  # returns False

    array_order = []
    root = createTree(array_order, 0, len(array_order))
    print(isBalanced(root))  # returns True


if __name__ == "__main__":
    main()
