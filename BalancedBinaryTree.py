# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity is O(n)
# Space Complexity is O(n)
class Solution(object):
    def __init__(self):
        self.heightMem = {}
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        
        def height(node):
            if node is None:
                return 0
            elif node in self.heightMem:
                return self.heightMem[node]
            elif node.left and node.right:
                self.heightMem[node] = max(height(node.left),height(node.right))+1
            elif node.left:
                self.heightMem[node] = height(node.left)+1
            elif node.right:
                self.heightMem[node] = height(node.right)+1
            else:
                self.heightMem[node] = 1
            #print(node.val,self.heightMem[node])
            return self.heightMem[node]
        if root is None:
            return True
        elif(abs(height(root.left) - height(root.right)) > 1):
            return False
        else:
            return self.isBalanced(root.left) and self.isBalanced(root.right)