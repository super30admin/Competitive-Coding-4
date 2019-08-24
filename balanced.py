"""
Time: O(n)
Space: O(n)
Leet: Accepted
Problems: None
"""

class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def maxHeight(root): #Function to find maximum height subtree of a given node
            if not root:
                return 0
            else:
                return 1 + max(maxHeight(root.left),maxHeight(root.right))

        if not root:
            return True

        if abs(maxHeight(root.left) - maxHeight(root.right)) > 1:
            return False #if imbalance return false
        else:
            #else check if both subtrees are balanced
            return self.isBalanced(root.left) and self.isBalanced(root.right)

        return True
