# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# at every node check the height from the leftt and right subtree, 
# in a bottom up manner, if any of subtrees is not balanaced return -1 
# from that subtree and, this way if the tree is not balanced -1 gets
# propagated from the child to parent



class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:

    def isBalanced(self, root):

        if root is None:
            return True
        return self.height(root) != -1

    
    def height(self, root):

        if root is None:
            return 0
        
        left = self.height(root.left)
        right = self.height(root.right) 
        
        if (abs(left-right) > 1):
            return -1
        
        if left == -1 or right == -1:
            return -1
        
        return max(left, right) + 1