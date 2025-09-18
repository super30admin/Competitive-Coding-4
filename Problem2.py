# https://leetcode.com/problems/balanced-binary-tree/description/


# Node class used to make the tree
class Node(object):
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

# Time Complexity : O(N)
# Space Complexity : O(h) -- h = height of the tree, h = n in worst case and h = logn in best case
# Did this code successfully run on GFG : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one. 
# We have to keep track of heights of the left subtree and the right subtree. Where the difference between the heights becomes > 1,
# then our binary tree is not height balanced. Also for any root its height = max(height of left subtree, height of right subtree)
# So we need keep maintaining height from the level of the leaves. So we do post order traversal.


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.flag = True

    def helper(self, root):
        # base
        if(not root):
            return 0

        if(not self.flag):
            # already found invalid case
            # return something that does not interfere in our result
            return -1

        # recurse        
        left = self.helper(root.left)
        right = self.helper(root.right)

        # logic
        if(abs(left - right) > 1):
            self.flag = False

        return 1 + max(left, right)

    def isBalanced(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        self.helper(root)
        return self.flag


root = Node(3)

node9 = Node(9)
root.left = node9
node20 = Node(20)
root.right = node20
node15 = Node(15)
node20.left = node15
node7 = Node(7)
node20.right = node7

sol = Solution()
print(sol.isBalanced(root))

root = Node(3)

node9 = Node(9)
root.left = node9
node20 = Node(20)
root.right = node20
node15 = Node(15)
node20.left = node15
node7 = Node(7)
node20.right = node7
node2 = Node(2)
node9.left = node2
node1 = Node(1)
node2.left = node1

sol = Solution()
print(sol.isBalanced(root))

