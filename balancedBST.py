"""
Approach 1 : Double recursion - Top down
Have a recursive height function and isBalanced function. 
1) Height function takes the TreeNode and returns 1+ max of left and right subtree height or -1 if node is None
2) isBalanced returns True for None nodes, and for non None nodes it checks returns abs difference is left and right height is < 2 and then 
logical "and" that with if left and right of given node is balanced or not.

TC  O (nlogn)
SC  O(n)

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def height(self, root):
        # if we hit the None, return -1
        if not root:
            return -1
        # else you just add 1 to each not-None node and then max of left and right height.
        return 1 + max(self.height(root.left),self.height(root.right))

    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        # if hit None, return True
        if not root:
            return True
        # else return abs diff in left height and right height, and call recursively on left and right.
        return abs(self.height(root.left) - self.height(root.right)) < 2 and self.isBalanced(root.left) and self.isBalanced(root.right)


"""Approach 2: Bottom up Recursion
In this approach, we are passing height on to the recursive stack. At each level we call left height and right height
for left and right subtrees, and pass height+1 to the helper to account for height upto the current node.
Finally we return 0, True .
Else for each level. we check if lbal or rbal is False, in which case we return 0,False, if not,
in the end, we check abs diff between lh and rh is <2 and return a bool along with 1+max(lh,rh)

TC: O(n) For every subtree, we compute its height in constant time as well as compare the height of its children.
SC: O(n). The recursion stack may go up to O(n) if the tree is unbalanced.

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root, 0)[1]
        
    def helper(self, root, height) -> (int, bool):
        # base case
        # when we hit None, return 0, True, height doesn't matter if we return 0 or -1
        # both will work,as long as we return True here
        # becuase we consider at this point the empty tree below is balanced(for the sake of calculations)
        if not root:
            return 0, True
        
        # logic
        # call the helper on left and right subtree, to get height and check if they are balanced
        # if they are not balanced, return 0, False
        lh, lbal = self.helper(root.left, height + 1)
        if not lbal:
            return 0, False
        rh, rbal = self.helper(root.right, height + 1)
        if not rbal:
            return 0, False
        # if both sides are balanced, then return 1 (for current ndoe) + max between height of lh and rh
        # and for bool return if the absolute difference is less than 2 
        return 1 + max(lh,rh) , abs(lh-rh) < 2