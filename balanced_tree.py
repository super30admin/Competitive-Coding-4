# // Time Complexity : O(nlogn)
# // Space Complexity : O(h)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


 # Compute the tree's height via recursion
def height(self, root):
    if root == None:
        return -1

    return 1 + max(self.height(root.left),self.height(root.right))

def isBalanced(self, root):
    # base case
    if not root:
        return True

    # Check if subtrees have height within 1. If they do, check if the
    # subtrees are balanced
    return abs(self.height(root.left)-self.root(root.right) < 2)\
         and self.isBalanced(root.right) and self.isBalanced(root.left)