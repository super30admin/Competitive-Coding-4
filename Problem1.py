# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    # tc : O(n) number of nodes
    # sc : O(h)
    def isBalanced(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        # intution 
        # brute force : top to bottom approach : first find the left height of the root, rigth height of the root and check if the heigth difference is not greater than 1 
        # and apart from checking the condition for root itself, we should also check the condition is satisfied for both the left and rigth tree 
        # for example edge case : left subtree[4-3-2] -1(root) -[2-3-4]( right subtree), left height at 1 is 3, right heigth 3 but at node 2 the left heigt is 2, rigth heigth is 0 which fails and not a balanced tree 
        # since we need to fnd the heigth at every point from top to bottom we are iteratign from root to leaf until we reach the leaf which increase the complextiy : tc : O(n) to check balanced or not *O(n) to find left and heights for each node
        # optimizing the approach instead of top to bottom will iterate from bottom to top, will pass both is balanced and also height as recrussive parameters, so we don't need to keep findign height from parsign from root to leaf instead we can use it from the recrussive function
        # in bottom to top approach , first will check if left is balanced, if not then return false , then right check,  onces the subtress are baalnced then wil check the root. 

        isbalanced, height = self.helper(root)

        return isbalanced

    def helper(self, root):

        #base condition
        if root is None: # if null node will assign its height as -1
            return True, -1


        # left check 
        leftbalanced, leftheight = self.helper(root.left)

        if leftbalanced is False:
            return False , 0 

        # rigth check
        rightbalanced, rightheight = self.helper(root.right)

        if rightbalanced is False:
            return False, 0

        isbalanced = abs(leftheight - rightheight) <2 
        height = max(leftheight, rightheight) + 1 # adding 1 , so for leaf node its height will be (-1) + 1 = 0 

        return isbalanced, height
