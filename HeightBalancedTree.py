# TC = O(n) we are visiting all the nodes
# SC = O(n) worst case when it is a skewed tree
# We do inorder dfs traversal, as we visit each node, we calculate height difference between left and right subtrees. In order for tree to be height balanced, tree has to balaned at all nodes.

class Solution:
    def isBalanced(self,root):
        if root == None: return True
        hightDiff = abs(self.helper(root.left) - self.helper(root.right))
        # track of current node height diff between its subtrees and track of its children(Bottom-up)
        return hightDiff and self.isBalanced(root.left) and self.isBalanced(root.right) 

    def helper(self, root):
        if root == None: return None
        # add 1 to the height for child nodes
        return 1 + max(self.helper(root.left), self.helper(root.right))
