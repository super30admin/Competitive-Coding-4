#TC: O(n)
#SC: O(1)

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class BalancedBST(object):

    def __height(self, root):

        if (root == None):
            return 0

        leftH = self.__height(root.left)
        rightH = self.__height(root.right)

        return 1 + max(leftH, rightH)

    def isBalanced(self, root):
        
        if (root == None or (root.left == None and root.right == None)):
            return True

        leftH = self.__height(root.left)
        rightH = self.__height(root.right)

        if (abs(leftH - rightH) > 1):
            return False

        return self.isBalanced(root.left) and self.isBalanced(root.right)