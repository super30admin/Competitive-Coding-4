
# TC : O(n)
# SC : Recursive stack
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None:
            return True

        lefth=self.height(root.left)
        righth=self.height(root.right)

        if lefth-righth>1 or righth-lefth>1:
            return False

        leftbal=self.isBalanced(root.left)
        rightbal=self.isBalanced(root.right)


        if leftbal and rightbal:
            return True
        else:
            return False

    def height(self,root):
        if root is None:
            return 0
        else:
            return 1+max(self.height(root.left),self.height(root.right)) 


'''
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isBalanced(self, root):
        “”"
        :type root: TreeNode
        :rtype: bool
        “”"
        def height(root):
            if root==None: return 0,True
            l=height(root.left)[0]
            r=height(root.right)[0]
            h=max(l,r)+1
            if abs(l-r)>1:
                return h,False
            else: return h,height(root.left)[1] and height(root.right)[1]
        return height(root)[1]

'''