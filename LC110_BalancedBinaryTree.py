# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
We will maintain a queue of all the nodes and will check the difference between left and right height at every node

TC = O(n) - n is the number of nodes
SC = O(n) - as we will store all the nodes in a queue

"""
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None :
            return True
        q = deque()
        q.append(root)
        while q:
            curr = q.popleft()
            if curr.left:
                q.append(curr.left)
            if curr.right:
                q.append(curr.right)
            rhs = self.getheight(curr.right)
            lhs = self.getheight(curr.left)
            if abs(lhs-rhs)>1:
                return False
        return True
    def getheight(self, node):
        if node == None:
            return 0
        
        lhs = self.getheight(node.left)
        
        rhs = self.getheight(node.right)
            
        return (1+max(lhs,rhs))
    